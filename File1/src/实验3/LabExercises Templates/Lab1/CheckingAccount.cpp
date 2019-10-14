// Lab 1: CheckingAccount.cpp
// Member-function definitions for class CheckingAccount.
#include <iostream>
using namespace std;

#include "CheckingAccount.h" // CheckingAccount class definition


CheckAccount::CheckAccount(double a , double b)
      :Account(a)
      {
          chargeFee = b;
      }

void CheckAccount::credit(double amount)
{
    cout<< "$" <<chargeFee <<" transaction fee charged" << endl;
    setBalance(getBalance() + amount -chargeFee);
}
bool CheckAccount::debit(double amount)
{
    if(amount <= getBalance())
    {
        if(getBalance() - amount <= 1.0){
            cout<< "$" <<chargeFee <<" transaction fee charged" << endl;
            setBalance(0.0);
        }
        else
            {
                cout<< "$" <<chargeFee <<" transaction fee charged" << endl;
                setBalance(getBalance() - amount - chargeFee );
            }
        return true ;
    }
    else
    {
        cout << "Debit amount exceeded account balance." << endl;
        return false ;
    }
}



/**************************************************************************
 * (C) Copyright 1992-2012 by Deitel & Associates, Inc. and               *
 * Pearson Education, Inc. All Rights Reserved.                           *
 *                                                                        *
 * DISCLAIMER: The authors and publisher of this book have used their     *
 * best efforts in preparing the book. These efforts include the          *
 * development, research, and testing of the theories and programs        *
 * to determine their effectiveness. The authors and publisher make       *
 * no warranty of any kind, expressed or implied, with regard to these    *
 * programs or to the documentation contained in these books. The authors *
 * and publisher shall not be liable in any event for incidental or       *
 * consequential damages in connection with, or arising out of, the       *
 * furnishing, performance, or use of these programs.                     *
 **************************************************************************/
