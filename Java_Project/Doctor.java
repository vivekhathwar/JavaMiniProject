public class Doctor {
    String name;
    int total,timeLeft;
    int mon=0,tue=0,wed=0,thurs=0,fri=0,sat=0,sun=0;
    Doctor(String name,int total){
        this.name=name;
        this.total=total;
        timeLeft=total;
    }

    void addToSched(String day,int t){
        switch(day){
            case "Monday":mon+=t;break;
            case "Tuesday":tue+=t;break;
            case "Wednesday":wed+=t;break;
            case "Thursday":thurs+=t;break;
            case "Friday":fri+=t;break;
            case "Saturday":sat+=t;break;
            case "Sunday":sun+=t;break;
        }
        timeLeft-=t;
    }
    int getTimeLeft(){
        return timeLeft;
    }

    String getName(){
        return(name);
    }
}

class Cell{
    private Doctor doc;
    Cell(Doctor d,int t){
        doc=d;
        String day = "";
        switch(t){
            case 0:day="Sunday";break;
            case 1:day="Monday";break;
            case 2:day="Tuesday";break;
            case 3:day="Wednesday";break;
            case 4:day="Thursday";break;
            case 5:day="Friday";break;
            case 6:day="Saturday";break;
            default:System.out.println("Wrong entry");break;
        }
        doc.addToSched(day,3);
    }

    public String getName(){
        return(doc.getName());
    }
}

class createSchedule{
	int a=0;
    private Cell[][] Schedule=new Cell[7][8];
    createSchedule(Doctor[] d){
        for(int i=0;i<7;i++){
            for(int j=0;j<8;j++){
                int num=(a++)%(d.length);
                while(d[num].getTimeLeft()<3) num=(1+num)%(d.length);
                Cell c=new Cell(d[num],i);
                Schedule[i][j]=c;
            }
        }
    }

    Cell[][] getSchedule(){
        return Schedule;
    }
}