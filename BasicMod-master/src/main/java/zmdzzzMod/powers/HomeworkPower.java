package zmdzzzMod.powers;

import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.actions.common.ReducePowerAction;
import com.megacrit.cardcrawl.actions.common.RemoveSpecificPowerAction;
import com.megacrit.cardcrawl.actions.utility.UseCardAction;
import com.megacrit.cardcrawl.actions.watcher.ChangeStanceAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.cards.DamageInfo;
import com.megacrit.cardcrawl.core.AbstractCreature;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.powers.AbstractPower;

import static zmdzzzMod.BasicMod.makeID;

public class HomeworkPower extends BasePower {
    public static final String POWER_ID = makeID("HomeworkPower");
    private static final AbstractPower.PowerType TYPE = AbstractPower.PowerType.BUFF;
    private static final boolean TURN_BASED = false;
    public static int cnts = 0;
    public static boolean flag=true;
    //The only thing TURN_BASED controls is the color of the number on the power icon.
    //Turn based powers are white, non-turn based powers are red or green depending on if their amount is positive or negative.
    //For a power to actually decrease/go away on its own they do it themselves.
    //Look at powers that do this like VulnerablePower and DoubleTapPower.

    public HomeworkPower(AbstractCreature owner, int amount) {
        super(POWER_ID, TYPE, TURN_BASED, owner, amount);
    }
    public void atStartOfTurn() {
        cnts = 0;
    }
    public void onUseCard(AbstractCard card, UseCardAction action) {
        /* 35 */     if (card.type == AbstractCard.CardType.POWER) {
            /* 36 */       cnts++;
            /*    */     }
        /*    */   }
    public void stackPower(int stackAmount) {
        super.stackPower(stackAmount);
        if(this.amount<=0){
            addToTop((AbstractGameAction)new RemoveSpecificPowerAction(this.owner, this.owner, HomeworkPower.POWER_ID));
        }
        if ((this.amount >= 5&&! owner.hasPower(ExamPower.POWER_ID)&&flag)){
            addToBot(new ApplyPowerAction(AbstractDungeon.player, AbstractDungeon.player, new ScorePower(AbstractDungeon.player, cnts)));
            addToBot(new ApplyPowerAction(AbstractDungeon.player, AbstractDungeon.player, new ExamPower(AbstractDungeon.player, 1),0));
            flag=false;
        }
        if(this.amount <5&& !flag){
            flag = true;
        }
    }

        public void updateDescription() {
            this.description = DESCRIPTIONS[0];
    }
}