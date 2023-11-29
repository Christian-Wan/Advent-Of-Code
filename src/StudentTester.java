public class StudentTester
{
    public static void main(String[] args)
    {
        Student alan = new Student("Alan Turing", 11, "Liberty High School");
        Student ada = new Student("Ada Lovelace", 5);
        Student mary = new Student("Mary Truman", 8);
        Student paul = new Student("Paul Rudd", 2, "Colerain Elementary School");
        Student cindy = new Student("Cindy Long", 4);

        System.out.println(alan);
        System.out.println(ada);
        System.out.println(mary);
        System.out.println(paul);
        System.out.println(cindy);
    }
}
