package zmdzzzMod.cards;

import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.actions.common.DamageAllEnemiesAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.core.AbstractCreature;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import com.megacrit.cardcrawl.powers.PoisonPower;
import zmdzzzMod.character.zmd;
import zmdzzzMod.powers.CSPower;
import zmdzzzMod.powers.HomeworkPower;
import zmdzzzMod.util.CardStats;

public class OxygenNot extends BaseCard {
    public static final String ID = makeID(OxygenNot.class.getSimpleName());
    private static final CardStats info = new CardStats(
            zmd.Meta.CARD_COLOR,
            CardType.ATTACK,
            CardRarity.UNCOMMON,
            CardTarget.ENEMY,
            1
    );

    private static final int DAMAGE = 10;
    private static final int UPG_DAMAGE = 5;

    public OxygenNot() {
        super(ID, info);

        setDamage(DAMAGE, UPG_DAMAGE); //Sets the card's damage and how much it changes when upgraded.
        this.isMultiDamage = true;
        setMagic(3,-1);
//        tags.add(CardTags.STARTER_STRIKE);
//        tags.add(CardTags.STRIKE);

//        setExhaust(true);
    }

    @Override
    public void use(AbstractPlayer p, AbstractMonster m) {
        addToBot((AbstractGameAction)new DamageAllEnemiesAction((AbstractCreature)p, this.multiDamage, this.damageTypeForTurn, AbstractGameAction.AttackEffect.NONE));
        addToBot(new ApplyPowerAction(AbstractDungeon.player, AbstractDungeon.player, new PoisonPower(p,p,magicNumber)));
//        addToBot((AbstractGameAction) new WhirlwindAction(p, this.multiDamage, this.damageTypeForTurn, this.freeToPlayOnce, 1));
    }
    public boolean canUse(AbstractPlayer p, AbstractMonster m) {
        boolean canUse = false;
        if(AbstractDungeon.player.hasPower(CSPower.POWER_ID)) {
            canUse = true;
        }
        return canUse;
    }

        @Override
    public AbstractCard makeCopy() { //Optional
        return new OxygenNot();
    }
}