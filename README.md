# MyCalendar
The initial screen comes with a main menu with following options: View
by, Create, Go to, Event list, Delete, and Quit. After the function of
an option is done, the main menu is displayed again for the user to
choose the next option.
Select one of the following options:
[L]oad   [V]iew by  [C]reate, [G]o to [E]vent list [D]elete  [Q]uit
The user may enter one of the letter highlighted with a pair of bracket
to choose an option. For example,
V
will choose the View by option.
[L]oad
The system loads events.txt to populate the calendar. If there is no
such file because it is the first run, the load function prompts a
message to the user indicating this is the first run.
[V]iew by
User can choose a Day or a Month view. If a Day view is chosen, the
calendar displays the current date. If there is an event(s) scheduled on
that day, display them in the order of start time of the event. With a
Month view, it displays the current month and highlights day(s) if any
event scheduled on that day. After a view is displayed, the calendar
gives the user three options: P, N, and M, where P, N, and M stand for
previous, next, and main menu, respectively. The previous and next
options allow the user to navigate the calendar back and forth by day if
the calendar is in a day view or by month if it is in a month view. If
the user selects m, navigation is done, and the user gets to access the
main menu again.
[D]ay view or [M]view ?
If the user selects D, then
Tuesday, Feb 27, 2017
Event on this day

[P]revious or [N]ext or [M]ain menu ?
If the user selects M, then

February 2017
Su Mo Tu We Th Fr Sa
1  2  3  4
5  6  7  8  9 10 11
12 13 14 15 16 17 18
19 20 21 22 23 24 25
26 27 28

[P]revious or [N]ext or [M]ain menu ?

[C]reate
This option allows the user to schedule an event. The calendar asks the
user to enter the title, date, starting time, and ending time of an
event. For simplicity, I consider one day event only. Also, let's assume
there is no conflict between events that user entered, and therefore the
program doesn't check if a new event is conflict with existing events.
Please stick to the following format to enter data:
Title: a string (doesn't have to be one word)
date: MM/DD/YYYY
Starting time and ending time: 24 hour clock such as 06:00 for 6 AM and
15:30 for 3:30 PM.
[G]o to
With this option, the user is asked to enter a date in the form of
MM/DD/YYYY and then the calendar displays the Day view of the requested
date including any event scheduled on that day in the order of starting
time.
[E]vent list
The user can browse scheduled events. The calendar displays all the
events scheduled in the calendar in the order of starting date and
starting time. An example presentation of events is as follows:
2017
Friday March 17 13:15 - 14:00 Dentist
Tuesday April 25 15:00 - 16:00 Job Interview

[D]elete
User can delete an event from the Calendar. There are two different ways
to delete an event: Selected and All.
[S]elected: all the events scheduled on the selected date will be
deleted.
[A]ll: all the events scheduled on this calendar will be deleted.
[S]elected or [A]ll ?
If the user enters s, then the calendar asks for the date as shown
below.
Enter the date.

06/03/2016

[Q]uit saves all the events scheduled in a text file called "events.txt"
in the order of starting date and starting time.
