#include <iostream>
using namespace std;

int main() {

    int num[10] = {8, 1, 4, 1, 6, 2, 1, 3, 4, 2};
    int x, y, i;

    x = 1;
    y = 2;

    num[x + y] = num[x] + 1;
    num[7] = num[1] + num[2];
    num[num[x]] = num[y] - num[2] + y;
    num[x + y] = x * y;
    num[3 + 4] = num[x + y] + 2;
    num[x - 1] = x + y + 2;
    num[num[x] + 1] = num[x] + num[y];
    num[num[5] + 1] = num[7] + 2;

    cout << "Vetor final: ";

    for (i = 0; i < 10; i++) {
        cout << num[i] << " ";
    }

    cout << endl;

    return 0;
}
