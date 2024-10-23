package SDP_assignment_4;

public class ReportGeneration {
    abstract class ReportGenerator {

        public final String generateReport() {
            StringBuilder report = new StringBuilder();
            report.append(formatHeader()).append("\n");
            report.append(formatBody()).append("\n");
            report.append(formatFooter());
            return report.toString();
        }

        protected abstract String formatHeader();

        protected abstract String formatBody();

        protected abstract String formatFooter();
    }

    class PDFReportGenerator extends ReportGenerator {

        @Override
        protected String formatHeader() {
            return "PDF Report Header";
        }

        @Override
        protected String formatBody() {
            return "PDF Report Body: Content of the PDF report.";
        }

        @Override
        protected String formatFooter() {
            return "PDF Report Footer";
        }
    }

    class HTMLReportGenerator extends ReportGenerator {

        @Override
        protected String formatHeader() {
            return "<h1>HTML Report Header</h1>";
        }

        @Override
        protected String formatBody() {
            return "<p>HTML Report Body: Content of the HTML report.</p>";
        }

        @Override
        protected String formatFooter() {
            return "<footer>HTML Report Footer</footer>";
        }
    }

    class PlainTextReportGenerator extends ReportGenerator {

        @Override
        protected String formatHeader() {
            return "Plain Text Report Header";
        }

        @Override
        protected String formatBody() {
            return "Plain Text Report Body: Content of the plain text report.";
        }

        @Override
        protected String formatFooter() {
            return "Plain Text Report Footer";
        }
    }

    class ReportingSystem {
        private ReportGenerator generator;

        public ReportingSystem(ReportGenerator generator) {
            this.generator = generator;
        }

        public String createReport() {
            return generator.generateReport();
        }
    }
}

