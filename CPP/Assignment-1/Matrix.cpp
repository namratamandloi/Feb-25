#include <iostream>
using namespace std;

class Matrix {
private:
    int row;
    int col;
    int **arr;
public:
    Matrix(int r, int c) {
        row = r;
        col = c;
        arr = new int*[row];
        for (int i = 0; i < row; ++i) {
            arr[i] = new int[col];
        }
    }
    
    ~Matrix() {
        for (int i = 0; i < row; ++i) {
            delete[] arr[i];
        }
        delete[] arr;
    }
    
    void acceptRecord() {
        cout << "Enter elements for a " << row << "x" << col << " matrix:\n";
        for (int i = 0; i < row; ++i) {
            for (int j = 0; j < col; ++j) {
                cout << "Element [" << i << "][" << j << "]: ";
                cin >> arr[i][j];
            }
        }
    }
    
    void printRecord() const {
        cout << "Matrix (" << row << "x" << col << "):\n";
        for (int i = 0; i < row; ++i) {
            for (int j = 0; j < col; ++j) {
                cout << arr[i][j] << " ";
            }
            cout << endl;
        }
    }
};

int main() {
    int r, c;
    cout << "Enter number of rows: ";
    cin >> r;
    cout << "Enter number of columns: ";
    cin >> c;
    Matrix m(r, c);
    m.acceptRecord();
    m.printRecord();
    return 0;
}
