package SDP_assignment_4;
import java.util.List;
import java.util.ArrayList;

public class DocumentVersionControl {
    class DocumentVersion {
        private final String content;
        private final String versionName;

        public DocumentVersion(String content, String versionName) {
            this.content = content;
            this.versionName = versionName;
        }

        public String getContent() {
            return content;
        }

        public String getVersionName() {
            return versionName;
        }
    }
    class Document {
        private String content;

        public Document() {
            this.content = "";
        }

        public void editContent(String newContent) {
            this.content = newContent;
        }

        public String getContent() {
            return content;
        }

        public DocumentVersion createVersion(String versionName) {
            return new DocumentVersion(content, versionName);
        }

        public void restoreVersion(DocumentVersion documentVersion) {
            this.content = documentVersion.getContent();
        }
    }
    class VersionControl {
        private final List<DocumentVersion> versions = new ArrayList<>();

        public void saveVersion(Document document, String versionName) {
            DocumentVersion version = document.createVersion(versionName);
            versions.add(version);
            System.out.println("Version '" + versionName + "' saved.");
        }

        public void listVersions() {
            if (versions.isEmpty()) {
                System.out.println("No versions available.");
            } else {
                System.out.println("Available versions:");
                for (int i = 0; i < versions.size(); i++) {
                    System.out.println((i + 1) + ". " + versions.get(i).getVersionName());
                }
            }
        }

        public void restoreVersion(Document document, int versionIndex) {
            if (versionIndex >= 0 && versionIndex < versions.size()) {
                DocumentVersion version = versions.get(versionIndex);
                document.restoreVersion(version);
                System.out.println("Restored to version '" + version.getVersionName() + "'.");
            } else {
                System.out.println("Invalid version index.");
            }
        }
    }
}
