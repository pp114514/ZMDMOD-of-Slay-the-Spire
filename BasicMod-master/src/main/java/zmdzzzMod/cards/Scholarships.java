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
import zmdzzzMod.powers.*;
import zmdzzzMod.util.CardStats;

public class Scholarships extends BaseCard {
    public static final String ID = makeID(Scholarships.class.getSimpleName());
    private static final CardStats info = new CardStats(
            zmd.Meta.CARD_COLOR,
            CardType.ATTACK,
            CardRarity.UNCOMMON,
            CardTarget.ENEMY,
            1
    );

//    private static final int DAMAGE = AbstractDungeon.player.hasPower(ScorePower.POWER_ID) ? AbstractDungeon.player.getPower(ScorePower.POWER_ID).amount*2 : 0;
//    private static final int UPG_DAMAGE = AbstractDungeon.player.hasPower(ScorePower.POWER_ID) ? AbstractDungeon.player.getPower(ScorePower.POWER_ID).amount*3 : 0;
    public static int MAGIC=5;
    public static int UPG_MAGIC=5;

    public Scholarships() {
        super(ID, info);
        setMagic(MAGIC,UPG_MAGIC);
//        setDamage(DAMAGE, UPG_DAMAGE); //Sets the card's damage and how much it changes when upgraded.

//        setExhaust(true);
    }

    @Override
    public void use(AbstractPlayer p, AbstractMonster m) {
        addToBot(new ApplyPowerAction(AbstractDungeon.player, AbstractDungeon.player, new ShiliPower(AbstractDungeon.player, magicNumber)));
        addToBot(new ApplyPowerAction(AbstractDungeon.player, AbstractDungeon.player, new HomeworkPower(AbstractDungeon.player, -magicNumber)));
        addToBot(new DamageAction(m, new DamageInfo(p, AbstractDungeon.player.hasPower(ScorePower.POWER_ID) ? AbstractDungeon.player.getPower(ScorePower.POWER_ID).amount: 0, DamageInfo.DamageType.NORMAL), AbstractGameAction.AttackEffect.SLASH_VERTICAL));
    }

    @Override
    public AbstractCard makeCopy() { //Optional
        return new Scholarships();
    }
}