package ch05;

/*
 * 관계(비교) 연산자
 * 연산의 결과는 true 또는 false로 반환된다.
 */

public class Operation5_1 {
    public static void main(String[] args) {
        // 게임 캐릭터 상태 설정
        int playerHealth = 50; // 플레이어의 체력
        int playerLevel = 10;  // 플레이어의 레벨
        int enemyHealth = 30;  // 적군 체력
        int enemyLevel = 14;   // 적군 레벨

        // 경계값 포함 : <=, >=
        // 경계값 미포함 : <, >

        // 1. 플레이어의 체력이 적 체력보다 높은지 확인하는 코드를 작성하고 출력
        System.out.println("playerHealth > enemyHealth : " + (playerHealth > enemyHealth));

        // 2. 플레이어의 체력이 위험 수준인 20 이하인지 확인하고 출력
        System.out.println("playerHealth <= 20 : " + (playerHealth <= 20));

        // 3. 플레이어와 적의 체력이 같은지 확인하고 출력
        System.out.println("playerHealth = enemyHealth : " + (playerHealth == enemyHealth));

        // 4. 플레이어의 레벨이 30 이상인지 확인하고 출력
        System.out.println("playerLevel >= 30 : " + (playerLevel >= 30));

        // 5. 플레이어의 체력이 30 미만인지 확인하고 출력
        System.out.println("playerHealth < 30 : " + (playerHealth < 30));

        // 6. 플레이어의 체력이 50을 초과하는지 확인하고 출력
        System.out.println("playerHealth > 50 : " + (playerHealth > 50));

    }  // end of main

}   // end of class
