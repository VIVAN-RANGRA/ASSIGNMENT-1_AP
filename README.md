# ASSIGNMENT-1_AP


README File for assignment of Library Portal .

For this project , I have created 5 classes namely -
1 - TimeCounter
2 - Book
3 - Member
4 - Library
5 - Main

We are using hashmap to store the books and members in the library.


TimeCounter class is used to calculate the time difference between the current time and the time when the book was issued.
It has a method called startTimer() which is used to start the timer and a method called stopTimer() which is used to stop the timer.
It has a method called getElapsedTime() which is used to return the time difference between the current time and the time when the book was issued.

Book class is used to create a book object.
1) id , copies , name , author as attributes.
2) inherits from time TimeCounter class and as a result can use its methods whenever its called .
3) getTitle method which returns the name of the book ,  getAuthor method which returns the name of the author of the book.
   and getId method which returns the id of the book.

Member class is used to create a member object.
1) name,age,phone number , fine and book as attributes.
2) getName method which returns the name of the member.
3) getAge method which returns the age of the member , getPhoneNumber method which returns the phone number of the member.
   and getFine method which returns the fine of the member.

4) Arraylist member_books which stores the books issued by the member.
5) borrow_book method which is used to issue a book to the member , it takes a book object as input and adds it to
   the member_books arraylist , it also starts the timer for the book object.
6) return_book method which is used to return a book by the member , it takes a book object as input and removes it from the
   member_books arraylist , it also stops the timer for the book object and calculates the fine for the book object.
7) total_fine method which is used to pay the fine of the member , it takes the amount to be paid as input and subtracts it from the fine of the member.
8) list_my_books method which is used to list all the books issued by the member.

Library class is used to create a library object.
1) arraylist books which stores the books in the library.
2) arraylist members which stores the members in the library.
3) add book method which is used to add a book to the library , it takes a book object as input and adds it to the books arraylist.
4) add member method which is used to add a member to the library , it takes a member object as input and adds it to the members arraylist.
5) has remove_book method which is used to remove a copy from the library , it takes int id and string title  as input and removes it from the books arraylist.
6) has remove_member method which is used to remove a member from the library , it takes a name as input and removes that object  from the members arraylist.
7) list_books method which is used to list all the books in the library.
8) view_all_members_with_books method which is used to list all the members in the library and their subsequent books.
9) search_member method which is used to search a member in the library , it takes a name and phone_number as input and returns the member object if found.
10) search_book method which is used to search a book in the library , it takes a title and id as input and returns the book object if found.

Main class is used to create a library object and perform all the operations on it.
It has a main method which is used to create a library object and perform all the operations on it.
It first prints that library portal has started and asks whether to enter as librarian or member or exit .

If librarian is selected , then it performs all the operations on the library object.
All the methods of library class are called in this section based upon the user 's choice.

If member is selected , then it asks for the name and phone number of the member and then performs all the operations on the member object.
All the methods of member class are called in this section based upon the user 's choice.

If exit is selected , then it exits the program.
All the prevalent exceptions are handled in this program.


THANK YOU !
