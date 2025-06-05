

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.concurrent.atomic.AtomicBoolean;
import com.github.kwhat.jnativehook.GlobalScreen;
import com.github.kwhat.jnativehook.keyboard.NativeKeyEvent;
import com.github.kwhat.jnativehook.keyboard.NativeKeyListener;
public class BGSAUTOSHELLS implements NativeKeyListener {
     public static AtomicBoolean running = new AtomicBoolean(true);
     
     public static Boolean running2 = true;
     public static Robot robot;
    public static void main(String [] args) throws AWTException, InterruptedException{
        robot = new Robot();

        int x = 1900;
        int y = 540;
       
           
        
        try{
            Thread.sleep(5000);

        }
        catch (Exception e) {
            
            }


            Thread Thread1 = new Thread(() -> {
                try {
                    
                    
                    while (running.get() && running2) {
                        // Forward movement
                        
                        robot.keyPress(KeyEvent.VK_W);
                        
                        Thread.sleep(5000);
                        robot.keyRelease(KeyEvent.VK_W);
                         Thread.sleep(250);
                        // Backward movement
                        robot.keyPress(KeyEvent.VK_S);
                        
                        Thread.sleep(5000);
                        robot.keyRelease(KeyEvent.VK_S);
                        Thread.sleep(250);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
                
            }); Thread1.start();
            Thread Thread2 = new Thread(() ->{
            mouseWhileMoving(x, y);
    }); Thread2.start();
            
        }

        
    


    private static void mouseWhileMoving(int startX, int y){
    
        try {
           while (running.get()){
            int x = startX;
            if (x >= 500) {
                for (x = 1900; x > 500 && running.get() && running2; x -= 10) {
                    robot.mouseMove(x, y);
                    Thread.sleep(10);
                }
            } else {
                for (x = 500; x < 1900 && running.get()&& running2; x += 10) {
                    robot.mouseMove(x, y);
                    Thread.sleep(10);
                }
            }
        }
        } catch (Exception e) {
            running.set(false);
        }
    }
      private static void releaseKeyWithSafety(int keyCode) {
        try {
            robot.keyRelease(keyCode);
        } catch (Exception e) {
            try {
                robot.keyRelease(keyCode);
            } catch (Exception ignored) {}
        }
    }
    
}
   
