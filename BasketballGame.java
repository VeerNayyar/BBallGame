
import java.util.Scanner;
public class BasketballGame{

    private String teamName;
    private int score;

    public String getTeamName(){
        return teamName;
    }

    public void setTeamName(String team){
        teamName = team;
    }

    public void onePoint(){
        score++;
    }

    public void twoPoints(){
        score+=2;
    }

    public void threePoints(){
        score+=3;
    }

    public void gameFinished(){

    }

    public int getScore(){
        return score;
    }

    public static void main(String[] args){
        BasketballGame Blazers = new BasketballGame();
        BasketballGame Celtics = new BasketballGame();

        Scanner kbd = new Scanner(System.in);
        System.out.println("Enter team 1's name:");
        String team1 = kbd.nextLine();
        Blazers.setTeamName(team1);

        System.out.println("Enter team 2's name:");
        String team2 = kbd.nextLine();
        Celtics.setTeamName(team2);

        team1 = Blazers.getTeamName();
        team2 = Celtics.getTeamName();

        System.out.println("Team 1 is: " + team1);
        System.out.println("Team 2 is: " + team2);

        boolean progress = true;

        while (progress){
            System.out.println("Enter a score:");
            Scanner score = new Scanner(System.in);
            String scoreInput = score.nextLine();
            if (scoreInput.equalsIgnoreCase("stop"))
                break;
            String substr1 = scoreInput.substring(0, scoreInput.lastIndexOf(" "));
            String substr2 = scoreInput.substring((scoreInput.lastIndexOf(" ") +1 ), scoreInput.length());

            System.out.println(substr1);
            System.out.println(substr2);
            if ((substr1.equalsIgnoreCase(team1) == false) && (substr1.equalsIgnoreCase(team2) == false)){
                System.out.println("Please enter a valid team name");
                continue; 
            }

            if  ((substr2.equals("1") == false) && (substr2.equals("2") == false) && (substr2.equals("3") == false)){
                System.out.println("Please enter a valid score");
                continue;
            }

            if (substr1.equalsIgnoreCase(team1)){
                if (substr2.equals("1"))
                    Blazers.onePoint();
                else if (substr2.equals("2"))
                    Blazers.twoPoints();
                else 
                    Blazers.threePoints();
            }

            if (substr1.equalsIgnoreCase(team2)){
                if (substr2.equals("1"))
                    Celtics.onePoint();
                else if (substr2.equals("1"))
                    Celtics.twoPoints();
                else 
                    Celtics.threePoints(); 
            }

            int score1 = Blazers.getScore();
            int score2 = Celtics.getScore();

            if (score1 < score2){
                System.out.println(team1 + " " + score1 + ";" + team2 + " " + score2);   
                System.out.println(team2 + " are in the lead");
            }
            else if (score1 == score2)
                System.out.println("The teams are tied at " + score1);
            else{
                System.out.println(team1 + " " + score1 + ";" + team2 + " " + score2);
                System.out.println(team1 + " are in the lead");  
            }
            
            
        }
    }
}