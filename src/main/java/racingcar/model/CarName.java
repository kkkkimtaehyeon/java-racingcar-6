package racingcar.model;

import java.util.Arrays;
import java.util.StringTokenizer;
import java.util.ArrayList;
import java.util.HashSet;

public class CarName {
    private String inputCarNames;
    private ArrayList<String> carList= new ArrayList<>();
    private ArrayList<String> clearCarList= new ArrayList<>();

    public void carNamesToList(String inputCarNames){
        this.inputCarNames = inputCarNames;
        //StringTokenizer cars = new StringTokenizer(inputCarNames, "[^ㄱ-ㅎㅏ-ㅣ가-힣a-zA-Z0-9]");
        String[] str = inputCarNames.split("[^ㄱ-ㅎㅏ-ㅣ가-힣a-zA-Z0-9]");
        this.carList.addAll(Arrays.asList(str));
        /*
        while(cars.hasMoreTokens()){
            this.carList.add(cars.nextToken());
        }
         */
    }
    public void setClearCarList(){
        isSeperatorNotComma(this.inputCarNames);
        isWrongNameFormat(carList);
        isSameCarName(carList);
        isCarNameLengthOver5(carList);

        this.clearCarList = carList;
    }
    public ArrayList<String> getClearCarList(){
        return clearCarList;
    }

    public void isWrongNameFormat(ArrayList<String> carList) throws IllegalArgumentException{ //depth 줄이기
        for(String car: carList){
            if(!car.matches("^[a-zA-Z]+$")){
                throw new IllegalArgumentException("자동차 이름은 알파벳이여야 합니다.");
            }
        }
    }
    public void isSameCarName(ArrayList<String> carList) throws IllegalArgumentException{
        HashSet<String> set = new HashSet<>(carList);
        if(set.size() != carList.size()) {
            throw new IllegalArgumentException("중복된 자동차 이름이 없어야 합니다.");
        }
    }
    public void isCarNameLengthOver5(ArrayList<String> carList) throws IllegalArgumentException{
        for(String car: carList){
            if(car.length() > 5){
                throw new IllegalArgumentException("자동차 이름의 길이는 5 이하여야 합니다.");
            }
        }
    }
    public void isSeperatorNotComma(String inputCarNames) throws IllegalArgumentException{
        int cnt = 0;
        for(Character c: inputCarNames.toCharArray()){
            if(c == ','){
                cnt++;
            }
        }
        if(cnt != carList.size()-1){
            throw new IllegalArgumentException("구분자는 자동차 이름 사이의 쉼표입니다.");
        }
    }
}
