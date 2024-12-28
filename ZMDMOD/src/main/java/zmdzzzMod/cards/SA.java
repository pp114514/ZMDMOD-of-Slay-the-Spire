package zmdzzzMod.cards;

import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.actions.common.DamageAction;
import com.megacrit.cardcrawl.actions.common.DamageRandomEnemyAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.cards.DamageInfo;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import zmdzzzMod.character.zmd;
import zmdzzzMod.powers.CSPower;
import zmdzzzMod.powers.HomeworkPower;
import zmdzzzMod.powers.ScorePower;
import zmdzzzMod.powers.ShiliPower;
import zmdzzzMod.util.CardStats;

public class SA extends BaseCard {
    public static final String ID = makeID(SA.class.getSimpleName());
    private static final CardStats info = new CardStats(
            zmd.Meta.CARD_COLOR,
            CardType.ATTACK,
            CardRarity.UNCOMMON,
            CardTarget.ENEMY,
            1
    );

    private static final int DAMAGE = 3;
    private static final int UPG_DAMAGE = 2;
//    private static final int MAGIC = 2;
//    private static final int UPG_MAGIC = 2;

    public SA() {
        super(ID, info);

        setDamage(DAMAGE, UPG_DAMAGE); //Sets the card's damage and how much it changes when upgraded.
//        setMagic(MAGIC, UPG_MAGIC);
//        this.isMultiDamage = true;

//        tags.add(CardTags.STARTER_STRIKE);
//        tags.add(CardTags.STRIKE);

//        setExhaust(true);
    }

    @Override
    public void use(AbstractPlayer p, AbstractMonster m) {
//        addToBot(new DamageAction(m, new DamageInfo(p, damage, DamageInfo.DamageType.NORMAL), AbstractGameAction.AttackEffect.SLASH_VERTICAL));
//        addToBot(new ApplyPowerAction(AbstractDungeon.player, AbstractDungeon.player, new HomeworkPower(AbstractDungeon.player, magicNumber)));
        for(int i = 1; i<=(AbstractDungeon.player.hasPower(HomeworkPower.POWER_ID)?AbstractDungeon.player.getPower(ScorePower.POWER_ID).amount:0); i++){
        addToBot(new DamageRandomEnemyAction(new DamageInfo(p, damage, DamageInfo.DamageType.NORMAL), AbstractGameAction.AttackEffect.SLASH_DIAGONAL));
        }

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
        return new SA();
    }
}