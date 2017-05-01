/**
 * Created by William Yu on 4/26/2017<br>
 * Email: wwy2286@gmail.com<br>
 * Purpose: To create a class Day with different methods and a Driver class to run it.<br>
 */
// create the class day
public class Day {
    public String [] dayOfWeek={"Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"};
    //attribute for day
    private int day;

    /**
     * default constructor
     */
    public Day(){
        day=0;
    }

    /**
     *
     * @param day Constructor with one parameter
     */
    public Day(int day){
        this.day = day;
    }

    /**
     *
     * @param day method for set day
     */
    public void setDay(int day){
        this.day = day;
    }

    /**
     *
     * @return method for get day
     */

    public String getDay(){
        return dayOfWeek[this.day];
    }

    /**
     *
     * @return method to get next day
     */

    public String nextDay(){
        return dayOfWeek[(this.day+1)%7];
    }

    /**
     *
     * @return method for previous day
     */
    public String previousDay(){
        if ((this.day-1)%7==-1){
            return dayOfWeek[6];
        } else{
            return dayOfWeek[(this.day-1)%7];
        }
    }

    /**
     *
     * @param day
     * @return the added day
     */
    public String addDay(int day){
        return dayOfWeek[(this.day+day)%7];
    }

    /**
     *
     * @return toString Method
     */

    public String toString(){
        return ("The day is "+dayOfWeek[this.day]);
    }
}
