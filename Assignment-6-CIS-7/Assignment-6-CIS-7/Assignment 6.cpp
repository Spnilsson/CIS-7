//Programmer:		Steffan Nilsson
//Date:				09/13/2017

#include <iostream>

using namespace std;

bool evenOrOdd(int num);

int main()
{
	int num;
	char choice = 'Y';

	do {
		
		cout << "Enter a number: ";
		cin >> num;

		cout << "\nThe number is ";
		if (evenOrOdd(num) == true)
			cout << " even.\n";
		else
			cout << " odd.\n";

		cout << "Enter another number (Y/N)? ";
		cin >> choice;
		cin.ignore();
	} while (toupper(choice) != 'N');
}

bool evenOrOdd(int num)
{
	if (num % 2 == 0)
		return true;
	else
		return false;
}
