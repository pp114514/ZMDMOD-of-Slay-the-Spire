package zmdzzzMod.cards;

import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.actions.common.ReducePowerAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import com.megacrit.cardcrawl.powers.PlatedArmorPower;
import zmdzzzMod.character.zmd;
import zmdzzzMod.powers.HomeworkPower;
import zmdzzzMod.powers.ShiliPower;
import zmdzzzMod.util.CardStats;

public class Boss extends BaseCard {
    public static final String ID = makeID(Boss.class.getSimpleName());
    private static final CardStats info = new CardStats(
            zmd.Meta.CARD_COLOR,
            CardType.POWER,
            CardRarity.UNCOMMON,
            CardTarget.SELF,
            1
    );

//    private static final int DAMAGE = 1000;
//    private static final int UPG_DAMAGE = 3;
    private static final int MAGIC=7;
    private static final int UPG_MAGIC=5;

    public Boss() {
        super(ID, info);
        setMagic(MAGIC,UPG_MAGIC);
//        setDamage(DAMAGE, UPG_DAMAGE); //Sets the card's damage and how much it changes when upgraded.

//        tags.add(CardTags.STARTER_STRIKE);
//        tags.add(CardTags.STRIKE);

//        setExhaust(true);
    }

    @Override
    public void use(AbstractPlayer p, AbstractMonster m) {
        addToBot(new ApplyPowerAction(AbstractDungeon.player, AbstractDungeon.player, new PlatedArmorPower(p,magicNumber)));
        addToBot(new ApplyPowerAction(AbstractDungeon.player, AbstractDungeon.player, new HomeworkPower(p,-magicNumber)));
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
        return new Boss();
    }
}