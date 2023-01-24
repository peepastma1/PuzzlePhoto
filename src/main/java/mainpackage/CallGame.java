/*No-Name
6313139 Ruttiyaporn Kongtrakul 
6313141 Vatcharapong Laklaem
6313174 Natthabodi Bochol
6213202 Nitipoom Soomsakit*/
package mainpackage;

public class CallGame {
    PlayerSaved         player = new PlayerSaved();
    Game                g = new Game();
    
    public CallGame(){}
    
    public void callGame(PlayerSaved player){
        g.setplayer(player);
        g.StartGame();
    }
}
