package cz.mendelu.vui2.agents;

import cz.mendelu.vui2.agents.greenfoot.AbstractAgent;
import java.util.List;
import java.util.ArrayList;

public class ReactionAgent extends AbstractAgent {

    public interface Rule {
        /**
         *
         */
        Action match(boolean isWall, boolean dirty, boolean dock, String actions);
    }

    private List<Rule> rules = new ArrayList<>();
    private String actions = "";

    public ReactionAgent(){
        rules.add((isWall, dirty, dock, actions)->(dock && (actions.length() > 250)) ? Action.TURN_OFF : null);
        rules.add((isWall, dirty, dock, actions)->(!isWall) ? Action.FORWARD : null);
        rules.add((isWall, dirty, dock, actions)->(dirty) ? Action.CLEAN : null);
        rules.add((isWall, dirty, dock, actions)->(isWall && (actions.length() > 1)) ? Action.TURN_LEFT : null);
    }

    @Override
    public Action doAction(boolean isWall, boolean dirty, boolean dock) {
        for (Rule rule : rules) {
            Action a = rule.match(isWall, dirty, dock, actions);
            if (a != null) {
                actions += a.code;
                return a;
            }
        }
        actions = "";
        return Action.TURN_OFF;
    }
}
