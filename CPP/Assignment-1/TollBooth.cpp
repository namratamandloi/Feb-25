
#include <iostream>
using namespace std;

class TollBooth {
private:
    int totalVehicles;
    double totalRevenue;

public:
    TollBooth() {
        totalVehicles = 0;
        totalRevenue = 0.0;
    }

    void reset() {
        totalVehicles = 0;
        totalRevenue = 0.0;
        cout << "Booth statistics have been reset.\n";
    }

    void vehiclePayingToll(int vehicleType, int count, double tollAmount) {
        totalVehicles += count;
        totalRevenue += tollAmount * count;

        string typeName;
        switch(vehicleType) {
            case 1: typeName = "Standard Car"; break;
            case 2: typeName = "Truck"; break;
            case 3: typeName = "Bus"; break;
            default: typeName = "Unknown Vehicle"; break;
        }

        cout << count << " " << typeName << "(s) processed. Total Toll: $" << tollAmount * count << "\n";
    }

    int getTotalVehicles() const {
        return totalVehicles;
    }

    double getTotalRevenue() const {
        return totalRevenue;
    }
};

int main() {
    TollBooth booth;
    int choice;

    const double CAR_TOLL = 2.0;
    const double TRUCK_TOLL = 5.0;
    const double BUS_TOLL = 10.0;

    do {
        cout << "\n=== Toll Booth Menu ===\n";
        cout << "1. Add standard car(s) and collect toll ($2 each)\n";
        cout << "2. Add truck(s) and collect toll ($5 each)\n";
        cout << "3. Add bus(es) and collect toll ($10 each)\n";
        cout << "4. Display total vehicles passed\n";
        cout << "5. Display total revenue collected\n";
        cout << "6. Reset booth statistics\n";
        cout << "7. Exit\n";
        cout << "Enter your choice: ";
        cin >> choice;

        int count;
        switch(choice) {
            case 1:
                cout << "Enter number of standard cars: ";
                cin >> count;
                booth.vehiclePayingToll(1, count, CAR_TOLL);
                break;
            case 2:
                cout << "Enter number of trucks: ";
                cin >> count;
                booth.vehiclePayingToll(2, count, TRUCK_TOLL);
                break;
            case 3:
                cout << "Enter number of buses: ";
                cin >> count;
                booth.vehiclePayingToll(3, count, BUS_TOLL);
                break;
            case 4:
                cout << "Total Vehicles Passed: " << booth.getTotalVehicles() << endl;
                break;
            case 5:
                cout << "Total Revenue Collected: $" << booth.getTotalRevenue() << endl;
                break;
            case 6:
                booth.reset();
                break;
            case 7:
                cout << "Exiting program.\n";
                break;
            default:
                cout << "Invalid choice. Please try again.\n";
        }
    } while (choice != 7);

    return 0;
}