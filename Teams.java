 import java.util.*;
public class MatchesProblem1 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter no.of teams: ");
        int n=sc.nextInt();
        System.out.println("Enter teams: ");
        ArrayList <String> teams=new ArrayList<>();
        ArrayList<HashSet<String>> combo=new ArrayList<>();
        ArrayList<HashSet<String>> combo1=new ArrayList<>();
        for(int i=0;i<n;i++)
        {
            teams.add(sc.next());
        }
        System.out.println(teams);
        ArrayList<ArrayList<String>> matches=new ArrayList<>();
        for(int i=0;i<n-1;i++)
        {
            for(int j=i+1;j<n;j++)
            {
                ArrayList<String> str=new ArrayList<>();
                HashSet <String> match=new HashSet<>();
                str.clear();
                match.clear();
                str.add(teams.get(i)+" Vs "+teams.get(j));
                match.add(teams.get(i));
                match.add(teams.get(j));
                matches.add(str);
                combo.add(match);
                HashSet<String> match1=new HashSet<>();
                match1.clear();
                match1.add(teams.get(i));
                match1.add(teams.get(j));
                combo1.add(match1);
            }
        }
        System.out.println(matches);
        System.out.println(combo);
        ArrayList<HashSet<String>> schedule=new ArrayList<>();
        while(schedule.size()!=matches.size())
        {
            schedule.add(combo.get(0));
            for(int i=0;i<combo.size();i++)
            {
                combo1.get(i).retainAll(schedule.get(schedule.size()-1));
                if((combo1.get(i).isEmpty()) &&(!schedule.contains(combo.get(i))))
                {
                    schedule.add(combo.get(i));
                    combo.remove(combo.get(i));
                    break;
                }
            }
            combo.remove(combo.get(0));
            combo1.clear();
            for(int i=0;i<n-1;i++)
            {
                for(int j=i+1;j<n;j++)
                {
                    HashSet<String> match1=new HashSet<>();
                    match1.clear();
                    match1.add(teams.get(i));
                    match1.add(teams.get(j));
                    combo1.add(match1);
                }
            }
            for(int i=0;i<schedule.size();i++)
            {
                combo1.remove(schedule.get(i));
            }
        }
        System.out.println(schedule);
    }
}

