package x21_ObjectsAndClasses.exercise;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class E4Articles2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        List<Article> articles = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String[] data = scanner.nextLine().split(", ");

            String title = data[0];
            String content = data[1];
            String author = data[2];

            Article article = new Article(title, content, author);
            articles.add(article);
        }
        String data = scanner.nextLine();

        switch (data) {
            case "title":
                // order by title
                // a -> article
                articles.stream()
                       // .sorted((a1, a2) -> a2.getTitle().compareTo(a1.getTitle()))
                        .forEach(article -> System.out.println(article.toString()));
                break;
            case "content":
                // order by content
                articles.stream()
                      //  .sorted((a1, a2) -> a2.getContent().compareTo(a1.getContent()))
                        .forEach(article -> System.out.println(article.toString()));
                break;
            case "author":
                // order by author
                articles.stream()
                        // .sorted((a1, a2) -> a2.getAuthor().compareTo(a1.getAuthor()))
                        .forEach(article -> System.out.println(article.toString()));
                break;
        }
    }

    public static class Article {
        String title;
        String content;
        String author;

        public Article(String title, String content, String author) {
            this.title = title;
            this.content = content;
            this.author = author;
        }

        public String getTitle() {
            return title;
        }

        public String getContent() {
            return content;
        }

        public String getAuthor() {
            return author;
        }

        @Override
        public String toString() {

            return String.format("%s - %s: %s", getTitle(), getContent(), getAuthor());
        }
    }
}
