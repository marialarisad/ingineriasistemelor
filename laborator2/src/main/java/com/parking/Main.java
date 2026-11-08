package org.example;

import java.util.*;
import java.util.stream.IntStream;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {

        List<Integer> x = new ArrayList<>();
        List<Integer> y = new ArrayList<>();
        List<Integer> xPlusY = new ArrayList<>();
        Set<Integer> zSet = new TreeSet<>();
        List<Integer> xMinusY = new ArrayList<>();
        int p = 4;
        List<Integer> xPlusYLimitedByP = new ArrayList<>();

        Random rand = new Random();


        IntStream.range(0, 5).forEach(i -> x.add(rand.nextInt(11)));
        IntStream.range(0, 7).forEach(i -> y.add(rand.nextInt(11)));

        System.out.println("x init: " + x);
        System.out.println("y init: " + y);
        Collections.sort(x);
        Collections.sort(y);
        System.out.println("x sort: " + x);
        System.out.println("y sort: " + y);
        System.out.println("x: " + x);
        System.out.println("y: " + y);

        xPlusY.addAll(x);
        xPlusY.addAll(y);
        Collections.sort(xPlusY);
        System.out.println("a) x+y: " + xPlusY);

        zSet.addAll(x);
        zSet.retainAll(y);
        System.out.println("b) z: " + zSet);

        xMinusY.addAll(x);
        xMinusY.removeAll(y);
        System.out.println("c) x-y: " + xMinusY);

        xPlusYLimitedByP.addAll(xPlusY);
        xPlusYLimitedByP.removeIf(val -> val > p);
        System.out.println("d) x+y <= " + p + ": " + xPlusYLimitedByP);
        System.out.println();
        System.out.println();
        List<Student> studenti = new ArrayList<>();
        studenti.add(new Student("Ionescu", "Andrei", "31/2"));
        studenti.add(new Student("Radu", "Elena", "31/1"));
        studenti.add(new Student("Dumitrescu", "Matei", "31/2"));
        studenti.add(new Student("Stan", "Diana", "31/1"));
        studenti.add(new Student("Vasilescu", "David", "31/2"));

        for (Student s : studenti) {
            for (int i = 0; i < 5; i++) {
                s.adaugaNota(rand.nextInt(7) + 4);
            }
        }

        studenti.sort(Comparator.comparing(Student::getGrupa).thenComparing(Student::getNume).thenComparing(Student::getPrenume));

        System.out.println("Sortat:");
        studenti.forEach(System.out::println);

        List<Student> integralisti = studenti.stream().filter(Student::esteIntegralist).collect(Collectors.toList());

        List<Student> restantieri = studenti.stream().filter(s -> !s.esteIntegralist()).collect(Collectors.toList());

        integralisti.sort((s1, s2) -> Double.compare(s2.medie(), s1.medie()));
        System.out.println();
        System.out.println("Integraliști:");
        for (Student s : integralisti) {
            System.out.println(s + " | Medie: " + s.medie());
        }

        restantieri.sort(Comparator.comparingInt(Student::nrRestante));
        System.out.println();
        System.out.println("Restanțieri:");
        for (Student s : restantieri) {
            System.out.println(s + " | Restanțe: " + s.nrRestante());
        }
    }
}


class Student {

    private String nume;
    private String prenume;
    private String grupa;
    private List<Integer> note;

    public Student(String nume, String prenume, String grupa) {
        this.nume = nume;
        this.prenume = prenume;
        this.grupa = grupa;
        this.note = new ArrayList<>();
    }

    public String getNume() {
        return nume;
    }

    public String getPrenume() {
        return prenume;
    }

    public String getGrupa() {
        return grupa;
    }

    public void adaugaNota(int nota) {
        note.add(nota);
    }

    public boolean esteIntegralist() {
        for (int nota : note) {
            if (nota < 5) return false;
        }
        return true;
    }

    public double medie() {
        if (note.isEmpty()) return 0;
        double sum = 0;
        for (int n : note) sum += n;
        return sum / note.size();
    }

    public int nrRestante() {
        int count = 0;
        for (int n : note) {
            if (n < 5) count++;
        }
        return count;
    }

    @Override
    public String toString() {
        return String.format("Grupa: %s | %s %s | Note: %s", grupa, nume, prenume, note);
    }
}