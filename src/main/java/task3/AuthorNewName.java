
/** Додати метод оновлення імені автора за id */


package task3;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

public class AuthorNewName {
    private static EntityManager em;
    private static int id;
    private static String name;

    public static void main(String[] args) {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("authorhelper");
        EntityManager em = factory.createEntityManager();
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
    }
    public static void updateAuthorName(EntityManager em, int id, String name) {
        AuthorNewName.em = em;
        AuthorNewName.id = id;
        AuthorNewName.name = name;
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();

        Author author = em.find(Author.class, id);
        if (author != null) {
            author.setName(name);
            em.persist(author);
        }

        transaction.commit();
    }
}