package pl.dabrowicz;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Collection;

public class Main {

    public static void main(String[] args) {
	// write your code here
        /*Frontend frontend = new Frontend();

        SwingUtilities.invokeLater(() -> {
            frontend.run();
        });*/
        Collection<Task> tasks = new ArrayList<>();
        tasks.add(new Game());

        for (Task task : tasks) {
            task.run();
        }


    }
}
