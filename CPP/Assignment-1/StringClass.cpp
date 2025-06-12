#include <iostream>
#include <cstring>
using namespace std;

class String {
private:
    int length;
    char *str;
public:
    
    String() {
        length = 0;
        str = new char[1];
        str[0] = '\0';
    }
    
    ~String() {
        delete[] str;
    }
    // Accepts a string from the user
    void acceptRecord() {
        char buffer[1000];
        cout << "Enter a string: ";
        cin.ignore();
        cin.getline(buffer, 1000);
        length = strlen(buffer);
        delete[] str;
        str = new char[length + 1];
        strcpy(str, buffer);
    }
    
    void printRecord() const {
        cout << "String: " << str << endl;
    }
};

int main() {
    String s;
    s.acceptRecord();
    s.printRecord();
    return 0;
}
