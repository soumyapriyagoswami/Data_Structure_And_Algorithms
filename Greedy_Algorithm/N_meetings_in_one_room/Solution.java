import java.util.*;
class Meeting{
    int start;
    int end;
    int position;

    Meeting(int start, int end, int position){
        this.start = start;
        this.end = end;
        this.position = position;
    }
}

class Meeting_comparator implements Comparator<Meeting>{
    @Override
    public int compare(Meeting first, Meeting second){
        if(first.end < second.end) return -1;
        else if(first.end > second.end)return 1;
        else if(first.position < second.position) return -1;
        return 1;
    }
}

public class Solution{
    static void maxMeetings(int start[], int end[], int n){
        ArrayList<Meeting> meet = new ArrayList<>();
        for(int i = 0; i < start.length; i++){
            meet.add(new Meeting(start[i], end[i], i+1));
        }

        Meeting_comparator mc = new Meeting_comparator();
        Collections.sort(meet,mc);
        ArrayList<Integer> answer = new ArrayList<>();
        if(meet.size() > 0){
            answer.add(meet.get(0).position);
            int limit = meet.get(0).end;

            for(int i = 1; i < meet.size(); i++){
                if(meet.get(i).start > limit){
                    limit = meet.get(i).end;
                    answer.add(meet.get(i).position);
                }
            }
        }
        System.out.println("The order of the performing of the meeting will be: ");
        for(int i = 0; i < answer.size(); i++){
            System.out.print(answer.get(i)+" ");
        }
    }
    public static void main(String[] args) {
        int n = 6;
        int start[] = {1,3,0,5,8,5};
        int end[] = {2,4,5,7,9,9};
        maxMeetings(start,end,n);
    }
}