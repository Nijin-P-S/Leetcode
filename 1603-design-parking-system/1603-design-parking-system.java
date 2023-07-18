class ParkingSystem {

    int big = 0, medium = 0, small = 0;
    int curBig = 0, curMed = 0, curSmall = 0;
    
    public ParkingSystem(int big, int medium, int small) {
        this.big = big;
        this.medium = medium;
        this.small = small;
    }
    
    public boolean addCar(int carType) {
        if(carType == 1){
            if(curBig >= big)
                return false;
            else{
                curBig++;
                return true;
            }
                
        }
        else if(carType == 2){
            if(curMed >= medium)
                return false;
            else{
                curMed++;
                return true;
            }
        }
        else if(carType == 3){
            if(curSmall >= small)
                return false;
            else{
                curSmall++;
                return true;
            }     
        }
        return false;
    }
}

/**
 * Your ParkingSystem object will be instantiated and called as such:
 * ParkingSystem obj = new ParkingSystem(big, medium, small);
 * boolean param_1 = obj.addCar(carType);
 */