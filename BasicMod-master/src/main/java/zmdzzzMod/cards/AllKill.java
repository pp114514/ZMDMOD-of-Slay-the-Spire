package zmdzzzMod.cards;

import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.actions.common.GainEnergyAction;
import com.megacrit.cardcrawl.actions.common.ReducePowerAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import zmdzzzMod.character.zmd;
import zmdzzzMod.powers.HomeworkPower;
import zmdzzzMod.powers.ScorePower;
import zmdzzzMod.powers.ShiliPower;
import zmdzzzMod.util.CardStats;

public class AllKill extends BaseCard {
    public static final String ID = makeID(AllKill.class.getSimpleName());
    private static final CardStats info = new CardStats(
            zmd.Meta.CARD_COLOR,
            CardType.SKILL,
            CardRarity.UNCOMMON,
            CardTarget.SELF,
            0
    );

//    private static final int DAMAGE = 1000;
//    private static final int UPG_DAMAGE = 3;
//    private static final int MAGIC=20;
//    private static final int UPG_MAGIC=15;

    public AllKill() {
        super(ID, info);
        setExhaust(true,false);
    }

    @Override
    public void use(AbstractPlayer p, AbstractMonster m) {
        if(p.hasPower(HomeworkPower.POWER_ID)){
            addToBot(new ApplyPowerAction(AbstractDungeon.player, AbstractDungeon.player, new ShiliPower(AbstractDungeon.player, p.getPower(HomeworkPower.POWER_ID).amount)));
            addToBot(new ApplyPowerAction(AbstractDungeon.player, AbstractDungeon.player, new HomeworkPower(AbstractDungeon.player, p.getPower(HomeworkPower.POWER_ID).amount)));
            addToBot((AbstractGameAction)new ReducePowerAction(p, p, HomeworkPower.POWER_ID, p.getPower(HomeworkPower.POWER_ID).amount));
        }
    }
    @Override
    public AbstractCard makeCopy() { //Optional
        return new AllKill();
    }
}