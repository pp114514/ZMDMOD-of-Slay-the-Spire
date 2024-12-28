package zmdzzzMod.relics;

import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.actions.common.RelicAboveCreatureAction;
import com.megacrit.cardcrawl.actions.utility.UseCardAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.core.AbstractCreature;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.powers.AbstractPower;
import zmdzzzMod.character.zmd;
import zmdzzzMod.powers.CSPower;
import zmdzzzMod.powers.ExamFormPower;
import zmdzzzMod.powers.HomeworkPower;
import zmdzzzMod.powers.ShiliPower;

import static com.megacrit.cardcrawl.cards.AbstractCard.CardType.ATTACK;
import static zmdzzzMod.BasicMod.makeID;

public class ZmdRelic extends BaseRelic {
    private static final String NAME = "ZmdRelic"; //The name will be used for determining the image file as well as the ID.
    public static final String ID = makeID(NAME); //This adds the mod's prefix to the relic ID, resulting in modID:MyRelic
    private static final RelicTier RARITY = RelicTier.COMMON; //The relic's rarity.
    private static final LandingSound SOUND = LandingSound.CLINK; //The sound played when the relic is clicked.
//    public static int cnt = 0;

    private static final int STRENGTH = 10; //For convenience of changing it later and clearly knowing what the number means instead of just having a 10 sitting around in the code.

    public ZmdRelic() {
        super(ID, NAME, zmd.Meta.CARD_COLOR, RARITY, SOUND);
    }

    @Override
    public void onUseCard(AbstractCard targetCard, UseCardAction useCardAction) {
        if(targetCard.type == ATTACK){
//            if(AbstractDungeon.player.hasPower(HomeworkPower.POWER_ID)&&AbstractDungeon.player.getPower(HomeworkPower.POWER_ID).amount<=0){
            if(AbstractDungeon.player.hasPower(HomeworkPower.POWER_ID)&&AbstractDungeon.player.getPower(HomeworkPower.POWER_ID).amount >= 1) {
//            cnt++;
                if (!AbstractDungeon.player.hasPower(ExamFormPower.POWER_ID)) {
                    addToBot(new ApplyPowerAction(AbstractDungeon.player, AbstractDungeon.player, new HomeworkPower(AbstractDungeon.player, -1)));
                    addToBot(new ApplyPowerAction(AbstractDungeon.player, AbstractDungeon.player, new ShiliPower(AbstractDungeon.player, 1)));
                }
                if (AbstractDungeon.player.hasPower(ExamFormPower.POWER_ID)) {
                    addToBot(new ApplyPowerAction(AbstractDungeon.player, AbstractDungeon.player, new HomeworkPower(AbstractDungeon.player, -2)));
                    addToBot(new ApplyPowerAction(AbstractDungeon.player, AbstractDungeon.player, new ShiliPower(AbstractDungeon.player, 2)));
                }
            }
        }
//        addToBot(new ApplyPowerAction(AbstractDungeon.player, AbstractDungeon.player, new StrengthPower(AbstractDungeon.player, STRENGTH)));
    }

//    @Override
//    public void atBattleStart() {
//        /* 24 */     flash();
//        /* 25 */     addToTop((AbstractGameAction)new ApplyPowerAction((AbstractCreature)AbstractDungeon.player, (AbstractCreature)AbstractDungeon.player, (AbstractPower)new StrengthPower((AbstractCreature)AbstractDungeon.player, 1), 1));
//        /* 31 */     addToTop((AbstractGameAction)new RelicAboveCreatureAction((AbstractCreature)AbstractDungeon.player, this));
//        /*    */   }
//    @Override
    public void atTurnStart() {
        /* 25 */     flash();
        /* 26 */     addToBot((AbstractGameAction)new RelicAboveCreatureAction((AbstractCreature)AbstractDungeon.player, this));
        /* 27 */     addToBot((AbstractGameAction)new ApplyPowerAction((AbstractCreature)AbstractDungeon.player, null, (AbstractPower)new HomeworkPower((AbstractCreature)AbstractDungeon.player, 3), 1));
        /*    */   }
    public void atBattleStart() {
        addToBot(new ApplyPowerAction(AbstractDungeon.player, AbstractDungeon.player, new CSPower(AbstractDungeon.player, 1)));
        addToBot(new ApplyPowerAction(AbstractDungeon.player, AbstractDungeon.player, new HomeworkPower(AbstractDungeon.player, 3)));
    }
    @Override
    public String getUpdatedDescription() {
        return DESCRIPTIONS[0];
    }
}
