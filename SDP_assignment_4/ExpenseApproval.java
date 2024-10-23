package SDP_assignment_4;

public class ExpenseApproval {
    abstract class Approver {
        protected Approver nextApprover;

        public void setNextApprover(Approver nextApprover) {
            this.nextApprover = nextApprover;
        }

        public abstract void approveExpense(ExpenseRequest request);
    }
    class TeamLead extends Approver {
        private static final double APPROVAL_LIMIT = 1000;

        @Override
        public void approveExpense(ExpenseRequest request) {
            if (request.getAmount() <= APPROVAL_LIMIT) {
                System.out.println("TeamLead approved the expense for " + request.getPurpose()+ " with amount $" + request.getAmount());
            } else {
                System.out.println("TeamLead cannot approve the expense, forwarding to Manager.");
                if (nextApprover != null) {
                    nextApprover.approveExpense(request);
                }
            }
        }
    }
    class Manager extends Approver {
        private static final double APPROVAL_LIMIT = 5000;

        @Override
        public void approveExpense(ExpenseRequest request) {
            if (request.getAmount() <= APPROVAL_LIMIT) {
                System.out.println("Manager approved the expense for " + request.getPurpose() + " with amount $" + request.getAmount());
            } else {
                System.out.println("Manager cannot approve the expense, forwarding to Director.");
                if (nextApprover != null) {
                    nextApprover.approveExpense(request);
                }
            }
        }
    }
    class Director extends Approver {
        private static final double APPROVAL_LIMIT = 10000;

        @Override
        public void approveExpense(ExpenseRequest request) {
            if (request.getAmount() <= APPROVAL_LIMIT) {
                System.out.println("Director approved the expense for " + request.getPurpose() + " with amount $" + request.getAmount());
            } else {
                System.out.println("Director cannot approve the expense, forwarding to CEO.");
                if (nextApprover != null) {
                    nextApprover.approveExpense(request);
                }
            }
        }
    }
    class CEO extends Approver {
        @Override
        public void approveExpense(ExpenseRequest request) {
            System.out.println("CEO approved the expense for " + request.getPurpose() + " with amount $" + request.getAmount());
        }
    }
    class ExpenseRequest {
        private double amount;
        private String purpose;

        public ExpenseRequest(double amount, String purpose) {
            this.amount = amount;
            this.purpose = purpose;
        }

        public double getAmount() {
            return amount;
        }

        public String getPurpose() {
            return purpose;
        }
    }
    class ApprovalChain {
        public Approver getApprovalChain() {
            Approver teamLead = new TeamLead();
            Approver manager = new Manager();
            Approver director = new Director();
            Approver ceo = new CEO();

            teamLead.setNextApprover(manager);
            manager.setNextApprover(director);
            director.setNextApprover(ceo);

            return teamLead;
        }
    }
}
