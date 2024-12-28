package zmdzzzMod.cards;

import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.common.*;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.cards.DamageInfo;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.core.AbstractCreature;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import zmdzzzMod.character.zmd;
import zmdzzzMod.powers.HomeworkPower;
import zmdzzzMod.powers.ScorePower;
import zmdzzzMod.powers.ShiliPower;
import zmdzzzMod.util.CardStats;

public class Fanding extends BaseCard {
    public static final String ID = makeID(Fanding.class.getSimpleName());
    private static final CardStats info = new CardStats(
            zmd.Meta.CARD_COLOR,
            CardType.SKILL,
            CardRarity.UNCOMMON,
            CardTarget.SELF,
            2
    );

//    private static final int DAMAGE = 1000;
//    private static final int UPG_DAMAGE = 3;
//    private static final int MAGIC=20;
//    private static final int UPG_MAGIC=15;

    public Fanding() {
        super(ID, info);
        setCostUpgrade(1);
        setMagic(15,5);
//        setExhaust(true,false);
    }

    @Override
    public void use(AbstractPlayer p, AbstractMonster m) {
        addToBot((AbstractGameAction)new GainBlockAction((AbstractCreature)p, (AbstractCreature)p, magicNumber));
        addToBot(new ReducePowerAction(AbstractDungeon.player, AbstractDungeon.player, HomeworkPower.POWER_ID, AbstractDungeon.player.hasPower(HomeworkPower.POWER_ID)?AbstractDungeon.player.getPower(HomeworkPower.POWER_ID).amount/2:0));
        addToBot(new ApplyPowerAction(AbstractDungeon.player, AbstractDungeon.player, new ShiliPower(p,AbstractDungeon.player.hasPower(HomeworkPower.POWER_ID)?AbstractDungeon.player.getPower(HomeworkPower.POWER_ID).amount/2:0)));
    }
    @Override
    public AbstractCard makeCopy() { //Optional
        return new Fanding();
    }
}