package zmdzzzMod.potions;

import com.badlogic.gdx.graphics.Color;
import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.actions.common.GainEnergyAction;
import com.megacrit.cardcrawl.core.AbstractCreature;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.helpers.CardHelper;
import zmdzzzMod.powers.HomeworkPower;

import static zmdzzzMod.BasicMod.makeID;

public class ColaPotion extends BasePotion {
    public static final String ID = makeID(ColaPotion.class.getSimpleName());

    private static final Color LIQUID_COLOR = CardHelper.getColor(255, 0, 255);
    private static final Color HYBRID_COLOR = CardHelper.getColor(255, 0, 255);
    private static final Color SPOTS_COLOR = null;
    public ColaPotion() {
        super(ID, 5, PotionRarity.COMMON, PotionSize.BOTTLE, LIQUID_COLOR, HYBRID_COLOR, SPOTS_COLOR);
    }

    @Override
    public String getDescription() {
        return DESCRIPTIONS[0] + potency + DESCRIPTIONS[1];
    }

    @Override
    public void use(AbstractCreature abstractCreature) {
        addToBot(new ApplyPowerAction(AbstractDungeon.player, AbstractDungeon.player, new HomeworkPower(AbstractDungeon.player,potency)));
    }
}