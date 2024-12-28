package zmdzzzMod.cards;

import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.actions.common.LoseHPAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import com.megacrit.cardcrawl.powers.VulnerablePower;
import com.megacrit.cardcrawl.powers.WeakPower;
import org.apache.commons.lang3.ObjectUtils;
import zmdzzzMod.character.zmd;
import zmdzzzMod.powers.MechanicPower;
import zmdzzzMod.powers.ShiliPower;
import zmdzzzMod.util.CardStats;

public class HeatTreatment extends BaseCard {
    public static final String ID = makeID(HeatTreatment.class.getSimpleName());
    private static final CardStats info = new CardStats(
            zmd.Meta.CARD_COLOR,
            CardType.SKILL,
            CardRarity.UNCOMMON,
            CardTarget.ENEMY,
            2
    );

//    private static final int DAMAGE = 10;
//    private static final int UPG_DAMAGE = 3;
    private static final int MAGIC=14;
    private static final int UPG_MAGIC=10;

    public HeatTreatment() {
        super(ID, info);
        setMagic(MAGIC,UPG_MAGIC);
//        setDamage(DAMAGE, UPG_DAMAGE); //Sets the card's damage and how much it changes when upgraded.

//        tags.add(CardTags.STARTER_STRIKE);
//        tags.add(CardTags.STRIKE);

//        setExhaust(true,false);
    }

    @Override
    public void use(AbstractPlayer p, AbstractMonster m) {
//        addToBot(new ApplyPowerAction(m, AbstractDungeon.player, new VulnerablePower(m,AbstractDungeon.player.hasPower(ShiliPower.POWER_ID)?AbstractDungeon.player.getPower(ShiliPower.POWER_ID).amount:0,false)));
//        addToBot(new ApplyPowerAction(m, AbstractDungeon.player, new WeakPower(m,AbstractDungeon.player.hasPower(ShiliPower.POWER_ID)?AbstractDungeon.player.getPower(ShiliPower.POWER_ID).amount:0,false)));
        addToBot(new LoseHPAction(m, m,magicNumber));
    }
    public boolean canUse(AbstractPlayer p, AbstractMonster m) {
        boolean canUse = false;
        if(AbstractDungeon.player.hasPower(MechanicPower.POWER_ID)) {
            canUse = true;
        }
        return canUse;
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
        return new HeatTreatment();
    }
}