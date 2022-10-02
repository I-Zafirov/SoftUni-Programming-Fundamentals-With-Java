package T33FinExamPreparation;

import java.util.*;

public class Concert {
    static class Band {
        private int time;
        private List<String> members = new ArrayList<>();
        private String name;

        public Band(String name) {
            this.name = name;
        }

        public int getTime() {
            return time;
        }

        public void play(int playTime) {
            this.time += playTime;
        }

        public void add(String member) {
            if (!this.members.contains(member)) {
                this.members.add(member);
            }
        }

        public List<String> getMembers() {
            return members;
        }

        public String getName() {
            return name;
        }
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        Map<String, Band> bandsByname = new HashMap<>();
        String command = scan.nextLine();
        while (!command.equals("start of concert")) {
            String[] commandBandParameters = command.split("; ");
            String bandName = commandBandParameters[1];
            Band band = bandsByname.get(bandName);
            if (band == null) {
                band = new Band(bandName);
                bandsByname.put(bandName, band);
            }
            if (commandBandParameters[0].equals("Play")) {
                int playTime = Integer.parseInt(commandBandParameters[2]);
                band.play(playTime);
            } else if (commandBandParameters[0].equals("Add")) {
                String[] members = commandBandParameters[2].split(", ");
                for (String member : members) {
                    band.add(member);
                }
            } else {
                throw new IllegalStateException("unknown command " + commandBandParameters[0]);
            }
            command = scan.nextLine();
        }
        int totalTime = 0;
        List<Band> bandsSorted = new ArrayList<>(bandsByname.values());
        Collections.sort(bandsSorted, (a, b) -> {
            int timeCompare = Integer.compare(b.getTime(), a.getTime());
            if (timeCompare == 0) {
                return a.getName().compareTo(b.getName());
            } else {
                return timeCompare;
            }
        });
        for (Band band : bandsSorted) {
            totalTime += band.getTime();
        }

        System.out.println("Total time: " + totalTime);
        for (Band band : bandsSorted) {
            System.out.println(band.getName() + " -> " + band.getTime());
        }
        String bandToPrint = scan.nextLine();
        System.out.println(bandToPrint);
        Band band = bandsByname.get(bandToPrint);
        for (String member : band.getMembers()) {
            System.out.println("=> " + member);
        }
    }
}
