package com.hydrago.refinements;

import static java.lang.Integer.parseInt;
import android.os.Build;
import android.util.Log;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

public class FileReader {

    //------------------------------------------------------------------------------------------

    public void prepLists() {
        Thread thread = new Thread() {
            @Override
            public void run() {
                try { setUsers(); } catch (Exception e) { Log.d("User Error", e.toString()); }
                try { setFriends(); } catch (Exception e) { Log.d("Friend Error", e.toString()); }
                try { setReminders(); } catch (Exception e) { Log.d("Reminder Error", e.toString()); }
            }
        };
        thread.setName("Preparation Thread");
        thread.start();
    }

    //------------------------------------------------------------------------------------------

    public ArrayList<ArrayList<String>> reader(String file) {
        ArrayList<ArrayList<String>> fileList = new ArrayList<>();

        try {
            InputStream inp = MainActivity.getReference().getAssets().open(file);
            BufferedReader reader = new BufferedReader(new InputStreamReader(inp));

            String line;
            line = reader.readLine();
            int j = 1;

            while (line != null) {
                ArrayList<String> tempList = new ArrayList<>();
                String[] split = line.split(",");
                int i = 0;

                while (i < split.length) {
                    Log.d(file + " Item | Row " + j, "Column - " + i + " | " + split[i].trim());
                    tempList.add(split[i].trim());
                    j += 1;
                    i += 1;
                }

                fileList.add(tempList);
                line = reader.readLine();
            }
            reader.close();
            inp.close();
        }
        catch (Exception e) {
            Log.d("File Error", e.toString());
        }

        return fileList;
    }

    //------------------------------------------------------------------------------------------

    public void setUsers() {
        ArrayList<ArrayList<String>> list = reader("users.csv");
        int i = 0;

        while (i < list.size()) {
            ObjectClasses.User user = new ObjectClasses.User();
            ArrayList<String> data = list.get(i);

            user.setUsername(data.get(0));
            user.setPassword(data.get(1));
            user.setImage("idk");

            ObjectClasses.users.add(user);
            i += 1;
        }
    }

    //------------------------------------------------------------------------------------------

    public void setFriends() {
        ArrayList<ArrayList<String>> list = reader("friends.csv");
        int i = 0;

        while (i < ObjectClasses.users.size()) {
            int j = 0;
            ObjectClasses.User user = ObjectClasses.users.get(i);

            while (j < list.size()) {
                ArrayList<String> data = list.get(i);

                if (user.getUsername().equals(data.get(0)) && !user.getUsername().equals(data.get(1))) {
                    user.setFriend(data.get(1)); }

                else if (!user.getUsername().equals(data.get(0)) && user.getUsername().equals(data.get(1))) {
                    user.setFriend(data.get(0)); }

                j += 1;
            }

            i += 1;
        }
    }

    //------------------------------------------------------------------------------------------

    public void setReminders() {
        ArrayList<ArrayList<String>> list = reader("reminders.csv");
        int i = 0;

        while (i < list.size()) {
            ObjectClasses.Reminder reminder = new ObjectClasses.Reminder();
            ArrayList<String> data = list.get(i);

            reminder.setTitle(data.get(0));
            reminder.setPriority(data.get(1));
            reminder.setRepType(data.get(2));
            reminder.setRepAmount(parseInt(data.get(3)));

            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                reminder.set_sDate(LocalDate.parse(data.get(4)));
                reminder.set_eDate(LocalDate.parse(data.get(5)));

                try {
                    reminder.setTime(LocalTime.parse(data.get(6)));
                }
                catch (Exception e) {
                    reminder.setAllDay(data.get(6));
                }

            }

            ObjectClasses.reminders.add(reminder);
            i += 1;
        }
    }

    //------------------------------------------------------------------------------------------
}
