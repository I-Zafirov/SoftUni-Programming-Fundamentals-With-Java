package T24AssociativeArrays.moreExercise;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ME04Snowwhite {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        List<Dwarf> dwarfsList = new ArrayList<>();

        while (!"Once upon a time".equals(input)) {
            String[] tokens = input.split(" <:> ");
            String dwarfName = tokens[0];
            String dwarfHatColor = tokens[1];
            int dwarfPhysics = Integer.parseInt(tokens[2]);
            boolean isInList = false;
            for (Dwarf dwarf : dwarfsList) {
                if (dwarf.getDwarfName().equals(dwarfName) &&
                        dwarf.getDwarfHatColor().equals(dwarfHatColor)) {
                    dwarf.setDwarfPhysics(Math.max(dwarf.getDwarfPhysics(), dwarfPhysics));
                    isInList = true;
                }
            }
            if (!isInList) {
                Dwarf dwarf = new Dwarf(dwarfName, dwarfHatColor, dwarfPhysics);
                dwarfsList.add(dwarf);
                // dwarfsList.add(new Dwarf(name, hatColor, physics));
            }
            input = scanner.nextLine();
        }

        dwarfsList.stream()
                .sorted((f, s) -> {
                    int result = Integer.compare(s.getDwarfPhysics(), f.getDwarfPhysics());
                    if (result == 0) {
                        int countFirst = 0;
                        int countSecond = 0;

                        for (Dwarf dwarf : dwarfsList) {
                            if (dwarf.getDwarfHatColor().equals(f.dwarfHatColor)) {
                                countFirst++;
                            }
                            if (dwarf.getDwarfHatColor().equals(s.dwarfHatColor)) {
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

    private static class Dwarf {
        String dwarfName;
        String dwarfHatColor;
        int dwarfPhysics;

        public Dwarf(String dwarfName, String dwarfHatColor, int dwarfPhysics) {
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
