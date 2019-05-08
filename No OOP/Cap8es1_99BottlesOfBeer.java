/*Exercise 8.1 The purpose of this exercise is to take a problem and break
it into smaller problems, and to solve the smaller problems by writing simple
methods. Consider the first verse of the song “99 Bottles of Beer”:
99 bottles of beer on the wall,
99 bottles of beer,
ya’ take one down, ya’ pass it around,
98 bottles of beer on the wall.
Subsequent verses are identical except that the number of bottles gets smaller
by one in each verse, until the last verse:
No bottles of beer on the wall,
no bottles of beer,
ya’ can’t take one down, ya’ can’t pass it around,
’cause there are no more bottles of beer on the wall!
And then the song (finally) ends.
Write a program that displays the entire lyrics of “99 Bottles of Beer”. Your
program should include a recursive method that does the hard part, but you
might want to write additional methods to separate other parts of the program.
As you develop your code, test it with a small number of verses, like 3.*/

public class Cap8es1_99BottlesOfBeer {
    public static void main(String[] args){
        lyrics(99);
    }

    public static void lyrics(int n){
        if (n==0){
            System.out.println("No bottles of beer on the wall,\n"
                    +"No bottles of beer,\nya’ take one down, ya’ pass it around,\n"
                    +"No bottles of beer on the wall.");
            return;
        }
        System.out.println(n+" bottles of beer on the wall,\n"
                            +n+" bottles of beer,\nya’ take one down, ya’ pass it around,\n"
                            +n+" bottles of beer on the wall.\n");
        delay();
        lyrics(n-1);
    }
    public static void delay() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {}
    }
}
