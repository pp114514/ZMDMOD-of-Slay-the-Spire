package zmdzzzMod.cards;

import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.actions.common.DamageAction;
import com.megacrit.cardcrawl.actions.common.ReducePowerAction;
import com.megacrit.cardcrawl.actions.common.RemoveSpecificPowerAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.cards.DamageInfo;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import zmdzzzMod.character.zmd;
import zmdzzzMod.powers.HomeworkPower;
import zmdzzzMod.powers.ScorePower;
import zmdzzzMod.powers.ShiliPower;
import zmdzzzMod.util.CardStats;

public class Presentation extends BaseCard {
    public static final String ID = makeID(Presentation.class.getSimpleName());
    private static final CardStats info = new CardStats(
            zmd.Meta.CARD_COLOR,
            CardType.ATTACK,
            CardRarity.UNCOMMON,
            CardTarget.ENEMY,
            2
    );

//    private static final int DAMAGE = 1000;
//    private static final int UPG_DAMAGE = 3;
//    private static final int MAGIC=20;
//    private static final int UPG_MAGIC=15;

    public Presentation() {
        super(ID, info);
        setCostUpgrade(1);
//        setExhaust(true,false);
    }

    @Override
    public void use(AbstractPlayer p, AbstractMonster m) {
        if(p.hasPower(ScorePower.POWER_ID)){
//            addToBot(new ApplyPowerAction(AbstractDungeon.player, AbstractDungeon.player, new ShiliPower(AbstractDungeon.player, p.getPower(HomeworkPower.POWER_ID).amount)));
//            addToBot(new ApplyPowerAction(AbstractDungeon.player, AbstractDungeon.player, new HomeworkPower(AbstractDungeon.player, p.getPower(HomeworkPower.POWER_ID).amount)));
//            addToBot((AbstractGameAction)new ReducePowerAction(p, p, HomeworkPower.POWER_ID, p.getPower(HomeworkPower.POWER_ID).amount));
            addToBot(new DamageAction(m, new DamageInfo(p, AbstractDungeon.player.getPower(ScorePower.POWER_ID).amount*magicNumber, DamageInfo.DamageType.NORMAL), AbstractGameAction.AttackEffect.SLASH_VERTICAL));
        }
        addToBot(new ApplyPowerAction(AbstractDungeon.player, AbstractDungeon.player, new ShiliPower(p,AbstractDungeon.player.hasPower(HomeworkPower.POWER_ID)?AbstractDungeon.player.getPower(HomeworkPower.POWER_ID).amount:0)));
        addToTop((AbstractGameAction)new RemoveSpecificPowerAction(p, p, HomeworkPower.POWER_ID));
    }
    @Override
    public AbstractCard makeCopy() { //Optional
        return new Presentation();
    }
}