#ifndef CORNERGROCER_H
#define CORNERGROCER_H

#include <map>
#include <string>
using namespace std;

/*
 * CornerGrocer class
 * ------------------
 * Stores item frequencies and provides functions
 * to load data, search, print frequencies, and
 * print histograms with random colors.
 */
class CornerGrocer {
private:
    map<string, int> frequencies;  // Stores item -> frequency
    string colors[6] = {           // ANSI escape color codes
        "\033[31m", // Red
        "\033[32m", // Green
        "\033[33m", // Yellow
        "\033[34m", // Blue
        "\033[35m", // Magenta
        "\033[36m"  // Cyan
    };

public:
    void LoadData(const string& filename);   // Load from input file
    void SaveData(const string& filename);   // Save to backup file
    void SearchItem(const string& item);     // Search single item
    void PrintFrequencies();                 // Print all frequencies
    void PrintHistogram();                   // Print histogram w/ colors
};

#endif

