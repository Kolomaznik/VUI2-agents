package cz.mendelu.vui2.agents;

public enum Action {

    FORWARD('F'),
    TURN_LEFT('L'),
    TURN_RIGHT('R'),
    CLEAN('C'),
    TURN_OFF('F');


    public final char code;

    Action(char code){
        this.code = code;
    }
}
