#include <iostream>
#include <limits> // for numeric_limits
#include "cornergrocer.h"
using namespace std;

int main() {
    CornerGrocer tracker;
    tracker.LoadData("CS210_Project_Three_Input_File.txt");

    int choice;
    string item;

    do {
        // Display menu
        cout << "\n====== Corner Grocer Menu ======\n";
        cout << "1. Search for an item\n";
        cout << "2. Print all item frequencies\n";
        cout << "3. Print histogram\n";
        cout << "4. Exit\n";
        cout << "Enter your choice: ";

        // Read menu choice safely
        if (!(cin >> choice)) {
            cin.clear(); // clear the error flag
            cin.ignore(numeric_limits<streamsize>::max(), '\n'); // discard bad input
            cout << "Invalid input. Please enter a number.\n";
            continue; // restart loop
        }

        cin.ignore(numeric_limits<streamsize>::max(), '\n'); // clear leftover newline

        switch (choice) {
            case 1:
                cout << "Enter item to search: ";
                getline(cin, item); // read full line including spaces
                tracker.SearchItem(item);
                break;
            case 2:
                tracker.PrintFrequencies();
                break;
            case 3:
                tracker.PrintHistogram();
                break;
            case 4:
                cout << "Exiting program...\n";
                break;
            default:
                cout << "Invalid choice. Try again.\n";
        }
    } while (choice != 4);

    return 0;
}
