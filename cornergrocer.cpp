#include "cornergrocer.h"
#include <iostream>
#include <fstream>
#include <cstdlib>   // for rand()
#include <ctime>     // for seeding rand()
#include <algorithm> // for transform
using namespace std;

/*
 * Helper function to convert a string to lowercase
 */
string toLower(const string& s) {
    string result = s;
    transform(result.begin(), result.end(), result.begin(),
              [](unsigned char c){ return tolower(c); });
    return result;
}

/*
 * LoadData
 * --------
 * Reads items from an input file, counts their frequencies,
 * and stores results in the map. Also creates a backup file.
 */
void CornerGrocer::LoadData(const string& filename) {
    ifstream inFile(filename);
    string item;

    if (!inFile) {
        cout << "Error: Cannot open input file.\n";
        return;
    }

    // Read each item word from the file and count occurrences
    while (inFile >> item) {
        frequencies[item]++;
    }
    inFile.close();

    // Create frequency.dat as a backup
    SaveData("frequency.dat");
}

/*
 * SaveData
 * --------
 * Writes the frequencies to a file (backup).
 */
void CornerGrocer::SaveData(const string& filename) {
    ofstream outFile(filename);
    for (auto& pair : frequencies) {
        outFile << pair.first << " " << pair.second << endl;
    }
    outFile.close();
}

/*
 * SearchItem
 * ----------
 * Looks up a specific item and prints its frequency,
 * or shows "not found" if missing.
 * Now case-insensitive.
 */
void CornerGrocer::SearchItem(const string& item) {
    string itemLower = toLower(item);
    for (auto& pair : frequencies) {
        if (toLower(pair.first) == itemLower) {
            cout << pair.first << " appears " << pair.second << " times.\n";
            return;
        }
    }
    cout << item << " not found.\n";
}

/*
 * PrintFrequencies
 * ----------------
 * Prints all items and their counts.
 */
void CornerGrocer::PrintFrequencies() {
    for (auto& pair : frequencies) {
        cout << pair.first << " " << pair.second << endl;
    }
}

/*
 * PrintHistogram
 * --------------
 * Prints each item followed by its frequency in parentheses,
 * and then a histogram made of █ characters.
 * Each item is randomly assigned a color for display.
 */
void CornerGrocer::PrintHistogram() {
    srand(time(0)); // seed random number generator

    // Find the longest item name
    size_t maxLength = 0;
    for (auto& pair : frequencies) {
        if (pair.first.length() > maxLength) {
            maxLength = pair.first.length();
        }
    }

    // Print histogram with aligned bars
    for (auto& pair : frequencies) {
        int freq = pair.second;
        string color = colors[rand() % 6]; // pick random color

        cout << color;

        // Pad the item name with spaces to align bars
        cout << pair.first;
        cout << string(maxLength - pair.first.length(), ' ');

        cout << " (" << freq << "): ";

        // Print the histogram bars
        for (int i = 0; i < freq; i++) {
            cout << "█";
        }

        cout << "\033[0m" << endl; // reset color
    }
}
