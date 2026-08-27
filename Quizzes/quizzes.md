### Quizzes for CS Year 2

Quiz#1: Create a class that generates a random number between 0 and 256, returns a string.
```.java
public class ranNum {
  public String ranNum() {
     int num = (int) (Math.random() * (256 + 1));
     return num + "";
  }

  public static void main(String[] args) {
    ranNum generator = new ranNum();
    System.out.println(generator.ranNum());
  }
}
```
## Proof of work:
<img width="1300" height="721" alt="Screenshot 2026-08-24 at 09 43 24" src="https://github.com/user-attachments/assets/da380ddb-60c1-4304-9535-1ce2c8faec0e" />

Task 2: Create a class that generates a valid IPv4 address. You may use the class RanNum()
<img width="1010" height="518" alt="Screenshot 2026-08-24 at 09 44 10" src="https://github.com/user-attachments/assets/0a086b7f-a6c7-4ee3-8682-a3748ff9a82a" />

Task 3:Create a class that receives a input String add and it checks for valid IPv4 address.
<img width="1010" height="533" alt="Screenshot 2026-08-24 at 09 44 28" src="https://github.com/user-attachments/assets/24201da6-ded6-4e91-84e8-5f71ce84ec28" />
