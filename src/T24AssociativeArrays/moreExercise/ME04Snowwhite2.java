package T24AssociativeArrays.moreExercise;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class ME04Snowwhite2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        Map<String, Dwarf> dwarfs = new HashMap<>();

        while (!"Once upon a time".equals(input)){
            String[] tokens = input.split(" <:> ");
            String dwarfName = tokens[0];
            String dwarfHatColor = tokens[1];
            int dwarfPhysics = Integer.parseInt(tokens[2]);

            if (dwarfs.containsKey(dwarfHatColor)){
                if (dwarfs.get(dwarfHatColor).getDwarfName().equals(dwarfName)){
                    dwarfs.get(dwarfHatColor).setDwarfPhysics(Math.max(dwarfs.get(dwarfHatColor)
                            .getDwarfPhysics(), dwarfPhysics));

                }
            } else {
                Dwarf dwarf = new Dwarf(dwarfName, dwarfHatColor, dwarfPhysics);
                dwarfs.put(dwarfHatColor, dwarf);
            }

            input = scanner.nextLine();
        }

        dwarfs.values()
                .stream()
                .sorted((f, s) -> {
                    int result = Integer.compare(s.getDwarfPhysics(), f.getDwarfPhysics());
                    if (result == 0){
                        int countFirst = 0;
                        int countSecond = 0;

                        for (Map.Entry<String, Dwarf> entry : dwarfs.entrySet()) {
                            if (entry.getValue().getDwarfHatColor().equals(f.dwarfHatColor)){
                                countFirst++;
                            }
                            if (entry.getValue().getDwarfHatColor().equals(s.dwarfHatColor)){
                                countSecond++;
                            }
                        }
                        result = Integer.compare(countSecond, countFirst);
                    }
                    return result;
                })
                .map(Dwarf::toString)
                .forEach(System.out::println);

/*        for (int i = 0; i < dwarfsList.size(); i++) {
            System.out.println(String.join(", ", dwarfsList.get(i).toString()));
        }*/

    }

    private static class Dwarf{
        String dwarfName;
        String dwarfHatColor;
        int dwarfPhysics;

        public Dwarf(String dwarfName, String dwarfHatColor, int dwarfPhysics){
            this.dwarfName = dwarfName;
            this.dwarfHatColor = dwarfHatColor;
            this.dwarfPhysics = dwarfPhysics;
        }

        public String getDwarfName() {
            return dwarfName;
        }

        public String getDwarfHatColor() {
            return dwarfHatColor;
        }

        public int getDwarfPhysics() {
            return dwarfPhysics;
        }

        public void setDwarfPhysics(int dwarfPhysics) {
            this.dwarfPhysics = dwarfPhysics;
        }

        @Override
        public String toString() {
            return String.format("(%s) %s <-> %d",
                    dwarfHatColor, dwarfName, dwarfPhysics);
        }
    }
}
