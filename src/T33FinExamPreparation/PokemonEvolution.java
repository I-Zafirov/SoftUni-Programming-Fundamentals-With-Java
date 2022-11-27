package T33FinExamPreparation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class PokemonEvolution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        Map<String, List<String>> pokemonLTI = new LinkedHashMap<>();

        String input = reader.readLine();
        while (!"wubbalubbadubdub".equals(input)) {
            String[] inputArr = input.split(" -> ");
            if (inputArr.length == 3) {
                //Store every pokemon and his evolutions
                //If you receive an existent pokemonName, you should add the new evolution to it.
                UpdatePokemonMap(pokemonLTI, inputArr);
            } else if (inputArr.length == 1) {
                //If you have received a pokemonName and you are printing its evolutions, the order is – by order of input.
                CheckForPokemonAndPrintIfFound(pokemonLTI, inputArr[0]);
            }

            input = reader.readLine();
        }

        //The pokemons must be printed by order of input.
        // Each pokemon’s evolutions must be ordered by evolution index in descending order.
        PrintPokemonsEvolutions(pokemonLTI);

    }

    private static void PrintPokemonsEvolutions(Map<String, List<String>> pokemonLTI) {
        pokemonLTI.forEach((key, value) -> {
            System.out.println("# " + key);

            value.stream().sorted((first, second) -> {
                int firstNum = Integer.parseInt(first.split(" <-> ")[1]);
                int secondNum = Integer.parseInt(second.split(" <-> ")[1]);

                return Integer.compare(secondNum, firstNum);
            }).forEach(System.out::println);
        });
    }

    private static void CheckForPokemonAndPrintIfFound(Map<String, List<String>> pokemonLTI, String pokemonName) {
        if (pokemonLTI.containsKey(pokemonName)) {
            System.out.println("# " + pokemonName);
            for (String evolutionTypeIndex : pokemonLTI.get(pokemonName)) {
                System.out.println(evolutionTypeIndex);
            }
        }
    }

    private static void UpdatePokemonMap(Map<String, List<String>> pokemonLTI, String[] inputArr) {
        String pokemonName = inputArr[0];
        String evolutionTypeIndex = inputArr[1] + " <-> " + inputArr[2];

        pokemonLTI.putIfAbsent(pokemonName, new LinkedList<>());
        pokemonLTI.get(pokemonName).add(evolutionTypeIndex);
    }
}
