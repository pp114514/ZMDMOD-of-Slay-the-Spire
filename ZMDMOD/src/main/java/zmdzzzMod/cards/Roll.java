package zmdzzzMod.cards;

import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.actions.common.ReducePowerAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import zmdzzzMod.character.zmd;
import zmdzzzMod.powers.HomeworkPower;
import zmdzzzMod.powers.ShiliPower;
import zmdzzzMod.util.CardStats;

public class Roll extends BaseCard {
    public static final String ID = makeID(Roll.class.getSimpleName());
    private static final CardStats info = new CardStats(
            zmd.Meta.CARD_COLOR,
            CardType.SKILL,
            CardRarity.COMMON,
            CardTarget.SELF,
            0
    );

//    private static final int DAMAGE = 1000;
//    private static final int UPG_DAMAGE = 3;
    private static final int MAGIC=2;
    private static final int UPG_MAGIC=1;

    public Roll() {
        super(ID, info);
        setMagic(MAGIC,UPG_MAGIC);
//        setDamage(DAMAGE, UPG_DAMAGE); //Sets the card's damage and how much it changes when upgraded.

//        tags.add(CardTags.STARTER_STRIKE);
//        tags.add(CardTags.STRIKE);

//        setExhaust(true);
    }

    @Override
    public void use(AbstractPlayer p, AbstractMonster m) {
        addToBot(new ApplyPowerAction(AbstractDungeon.player, AbstractDungeon.player, new HomeworkPower(p,magicNumber)));
        addToBot(new ReducePowerAction(AbstractDungeon.player, AbstractDungeon.player, HomeworkPower.POWER_ID, magicNumber));
        addToBot(new ApplyPowerAction(AbstractDungeon.player, AbstractDungeon.player, new ShiliPower(p,magicNumber)));
    }

//    public boolean canUse(AbstractPlayer p, AbstractMonster m) {
//        boolean canUse = false;
//        if(AbstractDungeon.player.hasPower(HomeworkPower.POWER_ID)) {
//            if (p.getPower(HomeworkPower.POWER_ID).amount >= magicNumber) {
//                canUse = true;
//            }
//        }
//        return canUse;
//    }

    @Override
    public AbstractCard makeCopy() { //Optional
        return new Roll();
    }
}