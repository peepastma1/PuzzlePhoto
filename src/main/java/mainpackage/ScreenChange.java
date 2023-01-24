/*No-Name
6313139 Ruttiyaporn Kongtrakul 
6313141 Vatcharapong Laklaem
6313174 Natthabodi Bochol
6213202 Nitipoom Soomsakit*/
package mainpackage;
import mainpackage.MainApplication.MenuHandler;

public class ScreenChange {
    
    window window;
    
    public ScreenChange(window screen){
        window = screen;
    }
    public void showMainMenu(){
        window.MenuPanel.setVisible(true);
        window.StoryPanel.setVisible(false);
        window.SpeedPanel.setVisible(false);
    }
    public void showStoryMenu(){
        window.StoryPanel.setVisible(true);
        window.MenuPanel.setVisible(false);
        window.SpeedPanel.setVisible(false);
    }
    public void showSpeedMenu(){
        window.StoryPanel.setVisible(false);
        window.MenuPanel.setVisible(false);
        window.SpeedPanel.setVisible(true);
    }
    public void exitGame(){
        System.exit(0);
    }
}
