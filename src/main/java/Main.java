import java.awt.Desktop;
import java.net.URI;
import java.util.Timer;
import java.util.TimerTask;

public class Main {
    public static void main(String[] args) throws Exception {
        String url = "https://example.com"; // غيّر هذا للرابط اللي بدك تفتحه
        int refreshMinutes = 5;

        Desktop.getDesktop().browse(new URI(url));
        System.out.println("فتح الموقع: " + url);

        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            public void run() {
                try {
                    Desktop.getDesktop().browse(new URI(url));
                    System.out.println("تم تحديث الصفحة...");
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }, refreshMinutes * 60 * 1000, refreshMinutes * 60 * 1000);
    }
}
