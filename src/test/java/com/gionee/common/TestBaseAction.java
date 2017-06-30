package com.gionee.common;

import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.Date;

import net.minidev.json.JSONObject;

import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.protocol.HTTP;

import com.gionee.common.service.security.impl.SecurityServiceImpl;
import com.gionee.common.utils.SecurityUtils;
import com.gionee.epay.client.EpaySDKReq;

public class TestBaseAction {
	
	//根据is_local_env判断是本地环境还是测试环境
	String url_local="http://localhost:8080/gionee-nfc-pay/nfcService.do";   //本地环境
	String url_test="http://121.41.108.162:8099/gionee-nfc-pay/nfcService.do";  //开发环境
	String url_product="http://settle-core.gionee.com/gionee-nfc-pay/nfcService.do";  //生产环境
	
	
	
	//测试环境
	String test_secret_key_0027="%20151123@Epay!AQEFAASCBKgwggSkAgEAAoIBAQC7Un9bOLF";
	String test_rsa_private_key_0027="MIIEvgIBADANBgkqhkiG9w0BAQEFAASCBKgwggSkAgEAAoIBAQC7Un9bOLF3An7x/gFrj365/r0mNJveUGC1atR5i1/W01djS5UL1Eoq7Vda9oBD1x8Xk42/90g/qZZ3A2BQYK9wwkIjrB6RXsCatSxjvpK5WwOOjvMvAMQZ59N58BeCxieCNa/L5xV1LaufvlCyTQiQ4JSmdL8HFf1ZSMl4Cv2sG5mr9rflWlyp22YH7vbA/CEUxJWU7OCbJbhCVWj1eIEmtlZhJmmja3zNtubPNmFaF/zaRkyKHLsj93wazZcLHa3x/JfG7MAUnXZV1qn0lPDjjAMzdiWSN0t1q0LnLCNztl+Mmp7jVO6P7Zr+QNAI5aFUlylg7Gc0XHkeGgMGVtuFAgMBAAECggEARbUZd5TNVYA0RVFErgYkHorRUJpbNouqsVgj4WcgLw1Og8DoohJJ11ejHlKEwLoY8+kQ4tLeq/Ir7/XtrXuNTeS8QBIY/ffIrMmmzydn6loYJMDFdkROtWUzqTjTRvL+WNIprTM9JPHt3/Auj2tjOKaaKqdfPv/L26HedzF/3L90PkqDVxLyfnrppqIOFXWcsxFLvlPrq6W4TxU4xODIaAR8aZb27mL7Ef1kibD7sxYP+MNbIDdkl0GCH3hFLwWwDQP4Wn7NNB33QIg0wWxNp4zkXMQ/yRvFseeuBgEjsrIG8JozHTe9XE/BUHiU5h8y79jUuC1CNNuETJEcFNogAQKBgQD5clhTQBKKXf3vW2qAKRtj2xcb9tODkDs4KdaNkyJUMTbePSvCHxLpFkSWt9hhGainu5Llgqh9Yr7d/leFyhFA9sEceOtTgIIxw/riCIclkwnX0bt+wnzO58/M3A0wSsfKUMW5jozToFKMfAa45Xoj4xtg8sTCsUfeO9YI3NJSAQKBgQDAPlWcbktfvQyy04b5mbqB7moY1umErwgvrjVLuLs6F8ArB28UzBVMEzomB3AVSXGcF3xmRx+LEZBbl5YjpvcFiXHs8KIoJlElGDmxvEK1ZfrCb8njLPz3RF00UJPeQG1Tvz3eU0g5oOiiF/pL44Npd5L/C8Gry7OPFZoWZkBBhQKBgQD43zZ0SNa2qjQyXPiSyXCEXhBeXBKHjp0m2ccwFP4JFdjyPgGseag6WXcxEFeX+SulvaU/yu4juyNHBP15hDNWp1nf+FyBQROkZy2l2nBL8rm9U4lHXO981xciAuI9rj5LAe9jxG+IrMnvU8a5Lmp/55RnU48v2AQmG3jd+sL0AQKBgF/1fXRVFaiXTCRjM6eZlaBPqoP1mqCRYeuy8IV4k3Q+8LxJvKfL6wGLQ2ZCJi9p9pysmHrRG6ymOsGNW/M1323TGpvjzX1vCugSPJI8X6v+WHn/pO2Rwj+Gz2NSqUyyKiA4gKBeP9oMOLLYdya0TR8zAZvveV/QkTNl3AE8TuylAoGBAOpc7HPSrrBMrymVFVynnm+lMlM98k64qrYK/JJUW1bjcjzs2Oh/AmPDQ5cimR9MiBlszZMMpv4UI3NOQnnMaVhPiazEMUYSAns0yCescmC3CzfNozxC+0xhJdYFqlPq9kpTD7VNVctj7u8g3I8Su5DGyOJZMpnxCSY9epCt+9N0";
	
	String test_secret_key_0003="%20151126@Epay!AQ9cfF5ONv/dIP6mWdwNgUGCvcbmzzZhWNg";
	String test_rsa_private_key_0003="MIIEvAIBADANBgkqhkiG9w0BAQEFAASCBKYwggSiAgEAAoIBAQCUbVt6h2PFSMa5T8eyfTbG8u3XbGHSvH3fzVnT1xXPTGvcqWbU6KXPvgGe65xkXsXqpc4Vso13cHa9XfIA2DtLxb6p5+mNL6gXwLJBlz1Ryq4mJ8gZ1ZJAGi6Ncoi+6UO0r5LPMkcFcJFlKp7Rtjlz2lyXZVIiZgcOQS5QR4egkr9XTYLBAmu37IWsNZoS/rxF7+ib0UarkvqNQ0QDvc1K9jNqzygVTcMGv2BSYhAAIsE7eV//HmMp+VYzrCa2U5XSTJzP/u9VPmd7ekdrO3R8FOlnmP+pwCABYp/ff9ieCAJpCwAvOXwsaO37UH5wgMtIAYHZq1xo5CTCFSnfM4k7AgMBAAECggEAeBAh4HKmVQ6ymXIckphQ+AvIMuscElCg7al50S96F+60jZGGehEbF3mWbAwgvNwg8tdeZhTB9GzH0BSvTtma1YdG3L+ZH7j+GwCn8QC6/G+cAYdKiQNGw42qPIb6cJvWRdGESxBbfN367r/UKsVhogJvxZOTJfosGO7G3O+PmWX/q2dUU5gft2ySEaPQT8r7hdgN++B9VqcnbXHJejNqVDYgtzJOCs+cyx9d/I207dizyU5FyN+GMGj8HWrwMf20G0zrqRDznG5001zhHbLXpLMIebF5V0UjZa3ZRf7Ekv7A/Qb3r2V87xJ0quSwmsCvIxGnoIcdlHf21gCBCiTRAQKBgQDL/CojHBoawP+PFHKjpEEv7GNfQyzzfSlqMLll3B9CljFng7Qjo2roVc7o7LE+P+kAEe5wNb3lkSel/PzGBw06ASMv3WvbZL6XynvEePFUzPsiGF58lDAHpvBseYLSLGBikntB/oPfRAkEGtZahHJvLTjGd4mxOvwHhZUnLQLYgQKBgQC6RnXb8DL7F7GhuNh8WPv9lgFcUO189g41WyMY6Mjp7R2+Bcsz0ljghWP9eZP5Lo4+nDAVVhU8MDtPhAQ4ZsXM6YxUHyhjLnqtRCtO0IZ9T5la7H63fChXO48ATa8NpmVE48TffoD8HlUCzXB/zSnfA+o6N1uBUFlvWoyebaXjuwKBgFHJoIeFS/4wJgeTVkfAoxZ4/HsErzBNnd5i/OMXeD01hUeQ6hhj/Ih9Z0HDLWndLCoIBoddNO+n3LLUFfG8gBQiwp39dLJ52WV5HVjweSrcKVFJXhErRXq796g2rDpi6p57Rwp15yAM4mSP8iRG+K8U/a+t3DqAgO7vI5eal4qBAoGAA5Er2p1b7JEElss6Yg82LCH+Pq1SDu2LUhw/rM9wYYJn6makAIcLqqkDRCxa2A+7K5nEFfSDDZcC27/0cLwPF6B1TnsWQ+f083J1vdmiaa3niuUyfAMFpr3+PAxAyOshz1LpRzpd7/YIvLgAaoIcRigGCT1cJDrMq6Q5QyNoZNcCgYBgtBngnLDaqYfKrwM34iyaDF9cUqd7XwUg+wBQyhK5CEde3JkCRI1UAidheiWmWvu11gnnwIl7N/bGsAD7y3Xo74NALL0F7MfMuhinWrAgd8Ot5JoUerSPJlpdqjo/4JvFZZnlmdRlkXK/iiV0CjnOuystOXBXM7RJT/geehUOPA==";
	
	String test_secret_key_0032="%20151126@Epay!AdminOerw/7paEmAuRAuzYK4MfyJUfiOgqB";
	String test_rsa_private_key_0032="MIIEvQIBADANBgkqhkiG9w0BAQEFAASCBKcwggSjAgEAAoIBAQCJzACgbfQ8BZIImXco22w9DPrIC1A0Nx/zQNDj7HHAHAbDJeRtW/LTyv76j/15aycCjP3bOfMjmYbo0hST6k9QovOYXPPGRMj494ok8Mh9d7q320b97fvfoNZkMVtm3sKUrkk56vD/uloSYC5EC7Ngrgx/IlR+I6CoFwHIfYcovfqEWuEwn3l7qB0qB1cOcveFS+id4+IOW9vElsPrGoLHQcLMRt5L58pJx860e5KCH4zoO/BzFWHvD1zfb3ukJO6LxqJ4SDY/0P2rglNlLKjCBPSqo9ilW6hcw1pL7qJM3nrTBk1R/0JPTRH3/zbZv9J8ZF9uBxOyUcjUDfmW2k8pAgMBAAECggEAFSBx+Cbji1BPU4I0As+hiLq0uHcDlP3eqC0H2eomho3Fe6YTn7C5Sj+VWFU7R6JmGL4FLdd0r8CaLpgHD6adAn/5WSLnPT7OkV1ikMdZ9eKlfgrgl44lT+QY+sOWf+8nZiRSlc6vpIWtyaN1dHlWxzvoLpXU3oIX362nWFXmoxhDoWofc8aWXQtcWh3bvHXhGb+K3IqGI8KpCBkcXrTbT2m0OhIAwVjd4d3eg3RNqMwKgpfApefaTQ/yomyniizvhIkIMOHs8KJJVHv3a5J+q2G/u1Ux52OZxRNk4Nemacx2fFbhLv2TLxmdOzN+5F3pMKHokp1KeQS530xG1n/gAQKBgQDRZwtFdmoG8QViB/+eN2vBdcBvgLjQowSqOvGiBf7cVOrDywJGBpO6ehjo5/dewPbx5kmhlk0O2NaYsK/C5njm4C7IYlKn7iMJErV3k+oEa9HTLsd6FtcrwCyJ4t871RekWb146CVF/vQzCONV3qnWP8+v96pFFRZ/wGm2/KZUEQKBgQCoddOppArLULTV5dixpamD7hoH442mQLiztZ2uVS29KneDzO5OZuroz8qbkveJbvmkaw+TZ/rd98uGkWqtj36I2xHSFoRJXLShrDtvMTYm1jBm24gOvuMHzfx4qL2vzogNsGIqry64UneJnSdxfm2w3Bgeoj0VyoAagLu/RT4BmQKBgCSUE2v2216LC52sOAKzO6d3oj3YBnCriU0TLtJWqcZjLv80nxkMXRHd8iv9GUD8BCcNSx9m2d8WEaZqdslc6RGrZ4CpbDbZalVTZ0+UDvTmwKhbK40wIDYMQ7tyXfxdpNuYsXhFVP19I7smek+trY03aFgcsymOHXgDbHQCfiuBAoGAW5Xjg0EKFUtFZVzWmI5GQNG8GTnfktlxEVLV7Sel/EgQPfm2Pa26XORLdJVMOs24r2j9SNipDPBhGEIKy11OH71qTNutA+2AzrzCe0s385lTKziDGfExoNaeQkMLDX+tfDO+yxH+xnsfPhPQk+V2YUbnXhA6QZScXMxMRkqw0VECgYEAyOSrnMs7nIy/3Wkyhj9yF8XoMFwtCxNvMoGX8GK5SXM3fbB5jmyUax1aM6ntew4Raxd0NxQXaZsTAEp7+eLdP13FgzXoF2SfPo82yG1cPkPQMwsFps6AQF/Da1H2D3a7HN+tiHTsVpBgRW4rbF9tHhPfbFrEMYuEvPjKwHdh0cI=";
	
	
	//生产环境(实际使用再替换，此处仍然是测试环境密钥)
	//生产环境
	String product_secret_key_0027="%20160421@Epay!AQEFAASCBKgwggSkAgETFoICTQC7Un9bNMN";
	String product_rsa_private_key_0027="MIIEvQIBADANBgkqhkiG9w0BAQEFAASCBKcwggSjAgEAAoIBAQDU82P7KUzhpsQdthO0mcpgK5kpIPYhPMIqrK5lGuvvM2iEt6TC8IYOkn8JrkPPLEFJYFDaOzeAVl9Y1Yf+lfTIfWOTI4ob02O82OkUtCJ6mrbkXefT1pZf8amAU+NXawV9DmNy28H9y/X6wEZjrPApjcCJQ1qqISZOxpEt9vW7r+jSRRcZLYo+JokSqA9Qn+NPKq5iED9VB6vmM8bby913GT0QyQXWTwX4FwRXLFZM5lPLaAJ4ZWMtCoQ5962k+siPwN3QpYnzQXRoSgWFBycFIjpr2SAhmd4dowZyDrmBTWxcnT90ggioQFq7ffErdYyLI+zYaGXzf3mx0gIwLLfJAgMBAAECggEANQaSK9Vh5oJ/LSLMj1kIMqBImBw0DZyygKvVFSn5++siKIIODdiUmQZTidaR3gGYFCxelajPLi7TuSwanAM9G7tVUyszVbByknC0wUoFl9/0kLLtaitx8Fwdp+27m2XzzOsLSmt8R7VE//Zm0KUcfExm2AckiV6NymnZdsea8uvrSVY75yYYoQm7fcdW3ovrNQrBAvbySmOXZaiaddWYdQs68JAIaiLvdOKKPdKbQJHmoAs1k8JeA9uGLAwl/oMWFUIQ9JQiKCoTmvpzFzwyGlFwdB0Rp449IKSHpPpZGlwKt7qx7XdHeIR9EDzmd3pzfDKxUKUR4LM6BuqfTPy+7QKBgQDwqYzikQN2Gv5wWAxV6B7L0mcgEB9S1WPK6NyoOtNpd/aNK+rPfoUgLX9BxpGoRgpUAxYF8mRjQyY4st7XBLZ7QnFLOnE8vwrr9citGOsGDHgiLp0Cue5xjW/HOYLquY5NoZK19gVMuXWYDY4T/YvsmPTBhPg6vq/MCRud6dyBxwKBgQDihbiT84sjmlOu4Q90WtQMuf3lW3bDaJDqlhZARWM3QuTBDyE+g2jMze8q1QzNokE1y2XGIuSP70OYMq3RxLD5Spw7l0UHP/mLbU/Z4NmL/06sTWZxUmY/kvtxZXl31JuaWYHUBYkQtbTyM0tzYPHIYKamn0+wILrdnNe9RkP57wKBgE3k0vDSNuiXPBtopDV5993IsBA0p67L2ozmaeUZhSvx5B81Q779GGGd2D6V4rcwVE904D/0gIGQTmKzomS95cJncvwCYnxi6UoON3GvSwKeLpQBulgTjhW6zZ8SAkmu3VxLG41Bn92BeYpJeN8Hha6Co1WvkBiTd5r2p7Wo5/IpAoGBAMTSS77CLnOQ9IVPKI6BHR6xvNo8zsSbZs9t+Yd+wuaRSRI2gzw+EiFiDh25YJaMFP0Y7iVqzA4EZ0cnQcCyltME8RsWJPRXsgxjvq4hoOTzwPgViJ2OaylyHOg6s4BbS5ihjR0cciwCtmZ8C2MFKRBiamr8odD3n2ZPkWT0WLwhAoGATgI8RK6dU7DfANvq7jg6Dl7VAOCzFACmyRsaLUfcDRbIoREIqDjLVlb5DckqOF0E6c5OFm5GaYPVDAUGCO4Ekol1Zx99Rn0pLzOJG4asblVIu0nXnPVsFR9bPjGoxJ1wTzK04sLLG90i4wJJSfwecm6Sv3V20YwauBamOOxSedM=";
	
	String product_secret_key_0003="%20160421@Epay!AQ9cfF5ONv/dIP7mWTmNgUGCvcbmzzZhTNT";
	String product_rsa_private_key_0003="MIIEvQIBADANBgkqhkiG9w0BAQEFAASCBKcwggSjAgEAAoIBAQCv+0ncemK9nCtU+IFRnKtPTm6eWEwrqipGxqArzhqEgciYwsZwYha+7DpDdbiMQRG6sABXqoK7kZHFVqnsKttwOn/HnugSAelxGdHaGZS3ssX2DA8c8xL7cSuUBywvgwkMzIgseEDVJ06MtjbIFn1wVCGpOn4Pxqcplp8Kt0JGSfxkUFmJAiIkdo0aIsLgF6c5+M+waNa26KgTNptAZ+aj6nZI54/xwfeQgiCllGuwDxZF4IVN2bNNd9sEemOP1QqufYQwoDLn6pWq+P2XqD2gSxfVs0WwgNB0jOu3zmveH4zY2N5ImGiHPrUsRZ+84e82MUiCJ1KSdVgCY0Piy+XRAgMBAAECggEAb1s1a7xNyumNSeFOA1R92lspCC2bVW4B/nMlW1K52Os/AdsOMoL/HaThYVqWgrmR/G3uaYrN2t7MPPEP6Q9dd/CsdqaI9wwaqaTK85WIU41eUslirtDpTA5aovq+7PmfumeaK3mUnMyYmdWbaJVCnte9zRXkOxtbH6fdz6wS1eJfK4AW2hMXizHGhtUJGRxEGRsnwelhf09gH8w0Cqhps7aysk3ZIIslmXBa4FPZ5D24iph7UvOCMhsS3HMUHIWSN11oB193t2GFSQruRYcYQWHgNYUmmfN+hBRc/dfwsVTakun4M6q5xv2crpHKpb4XYfbunK8SaHLk25+AfiJtIQKBgQD5MSOX5DhSx0ISodF21XumdMpO0Vj4Pz195MfNC5LFuvJiUcblnL+iBK4aMBWH7268sWZ1tiZ6QjQuuwKk0Ej0sy0k/4hsDjUuAeyjJGccun0rtcNeWbJk2/o5zpEpXiyO/73uTlEeZOwApf5JybL2OcZKY1THacgPvqyS8/VpXQKBgQC0yhzT2nuMoXWbUdZBJrBRSL+Hnj/Wgx7dfc4VKt3Eyy/3kA66z9pU05XF+4W3PlnSu2X2L/x6gZ7IVAyDpipMfz+iUEuGjuHvDvcliykkGtGHrd+0YRPtS9Xjnayh15xL8I9Od0dd+e4JIeaIj2ifbQBtq95EDBymY6nf/8vDBQKBgQDUYb0kR655XrpBhwkvbuPkCsYiRuq9KakPE132tFZzj9HlWi1apS3uuG5qg3DWWorW55ub15MTwDkZWun17k8/vzZKwj9TWQiaHanBodT/9zGXf2Lzlx8kNxgdDKFL0KfJeM43vSgF7531L4R6/x04HiWSYPZwvwdz497RoHsZQQKBgDQ+sCP84HVcd3siJDOBtbRXvJm5fqNEExhY8cQmNh5XxY3aQJd115dp6b9kF1lEGHsQkr+ZUHIqoTMtLsygqVqf70i9wYWqJtqJzZw44fPAGEsIUTx0TWjm4HG9sBS5FT7QzukTCTm8LzDObiuKneZsfpIy97Fceq8O4BmOd1jtAoGAESK3wyFMZr/YIEsXhN6Xr9hCIljQ6HWFc/rEDwXer1ydRKHJw6l8NybA1snuWrVmfxOqjzTcIQRhTIDBF6hqqgO9+No7bgn4Gm0vKxWJwW0AJUeDtEY2STxs+ORMzBOZVV2pBnlz7KtSVkcFZBc2/x4Gf8My8AFMqxxpbSvTwPA=";
	
	String product_secret_key_0032="%20160421@Epay!AdminOHsw/8paEmAuRAuzYK4MfyJUfiOttM";
	String product_rsa_private_key_0032="MIIEvAIBADANBgkqhkiG9w0BAQEFAASCBKYwggSiAgEAAoIBAQCf2CNgaJYEFaODH1MpmALzg/fTf86HcGVNWVsT/fPHnGUZYM/ORME3BYxIUdMGuYxUVOCfOk+Ily06Pw8cw+EVzoghHSbjd7PmPTXUOE5AH0xoQoaoywtQEb8fG77VucLjNmy4mcWy7ZpyDWHEcHaqUR+x4u/668IOSMXLthaMZzoq6V/7Y62B5Siksq3atiixtYGfibiyqgDS9cuW0JMPzk2EELl4aKpsIjo7ujpO2HvWP6CrGR5ttrMVfR12xz/zZKsYBT2nUzq9p/+2c+kqOLyvyy0ve0SC6nRGCtZzf4FL+VeL8JL6m0krVtE49eTShLttGezwBcj6Op0cVWSTAgMBAAECggEAR/wEYoR3GrvL+V8ACrlEivohf4QNNH1vgZf+JlC1mm1aMkWhEBlykh7TgDYpPNwO0GOxDMQr0S2T1qlTWvbzxOhP8em4+7OKtuNV/I6m3sW5mTJshlN6csKrOY07MfEITV7TM4c8u0m5xic0okyrhCQoi+nRfUTzDY/EU+ta2Dtl26ORNIuT7fmB3EaIjYOr1FuEyWrv7TlDE5nqeJjSh+UkberuSwF3OubcP4P7AZazSuSHgK9czQF14vQ7HA0nKKIat0aTLn1tDaU6VpTsj0JpFGEbDkfnj0iDWxwLOJ7nVcheT5WjcgmNSp7isUsKTsimbN9gfIDCLTgGn2JRoQKBgQDciHMXLsQ9rmkrBKr/aCxtOjDLdZbkWJPFboymaQ+6HLSJvgAfMLyHi9FDoTyx6Jykn5h842Ka579nNUlRP1YeX+CdlHJaS6EF0sNqy7CqBehk4CGiOU+jiQI8tQwFaLvu7lyppBcCdqVkwHimSuxgbdoB71GvpSj68kbF8xikmwKBgQC5jRPLThlnhTvXIeioFJS4FXUfmFWYe8zrA0opX1bTbUQXHsTprlIiYybeKEVoke9mKXzO1dOTW8qeSoZ+X/+hy4DU7l9TqG/j8lC1xnXZQdk7E5ghcNzEfnXSHsz5SG8WvXF7lJTS8U/PqwkTE0AUQly4BVsuFFzTLvuqaL0zaQKBgC+eSvObhoYnDdBbHq0tikI/iV+1UVKXCblcyIP6NYojPpxraU1S0bKW7yWiQB/OMVyelWeKFbWLCto3OFCR03+VhkOgVRzILcm7G7UIrGnaArcdakXECD0wjUocca8NUV8jGuEKbGl8wvPBV4vYq7eaoLNAQKwjhnjBLaT6e7y3AoGARHqvknnJYG5IjnZCQj4OQP4SUs3K0VLnZti49xnrlm4eEhZWABRI1c4YGydrrlMlsmOfX0qFIj5fQhopFtzhIFpVusAayGpCmTLl3KBZAAyQWoA5xiW8JHyziQ+7AEleTlsuVbiZUFyk4vSxjauuG4v+Yh//7bqwI3SUhujO4vkCgYBcVL9XVg2LZuraCZmxH6DP4/UkeyT8HWe46iWXAqLxpFszQel/noNTnjRVtg6rtP+f7GkOfMnwKM1cjEnPIixsj2/wvTmsSDZtiIoAmR0k1mIF91FY/2gCjDC8ID1QqluwtXKTKxSBf710gbi/mHMBmyS6eKqMpDV6dlNT25KXFg==";
	
	protected String trans_code;
	
	protected String req_sys="0027";
	
	//local:本地环境,test:测试环境，product：生产环境
	protected String  env="local";
	
	String version="5.0.0.a";
	
	protected boolean encrypt_open=false;
	
	protected boolean sign_open=false;
	
	
	protected EpaySDKReq epaySDKReq;//该类多线程下不安全,仅用作测试
	/**
	 * 安全载体CPCL
	 */
	protected String xTsmCplc;
	
	/**
	 * 交易请求方标识
	 */
	protected String x_smps_callerid;
	
	/**
	 * 请求的uri
	 */
	protected String uri;
	
	protected String secret_key_local="12345678";
	protected String secret_key_test="12345678!";
	protected String secret_key_product="12345678";
	
	public JSONObject getHeader(){
		Date date =new Date();
		SimpleDateFormat sdf=new SimpleDateFormat("yyyyMMdd");
		SimpleDateFormat sdf2=new SimpleDateFormat("yyyyMMddHHmmss");
		JSONObject jsonReq = new JSONObject(); 
		jsonReq.put("trans_code",trans_code);
		jsonReq.put("req_sys", req_sys);
		jsonReq.put("req_date", sdf.format(date));
		jsonReq.put("req_time", sdf2.format(date));
		jsonReq.put("version", "1.0.0");
		return jsonReq;
	}
	public String getUrl(){
		if(this.env.equals("test")){
			return url_test;
		}else if(this.env.equals("product")){
			return url_product;
		}
		return url_local;
	}

	public void setSign(JSONObject jsonReq,JSONObject jsonBody){
		try {
			String signContent=SecurityUtils.getAscStr(jsonBody.toJSONString());
			
			SecurityServiceImpl security=new SecurityServiceImpl();
			String sign=security.getMd5(signContent,this.getSecretKey());
			jsonReq.put("sign", sign);
		} catch (Exception e1) {
			e1.printStackTrace();
		}
	}
	
	public HttpPost getHttpHost(String json){
        HttpPost httpPost = new HttpPost(this.getUrl()+uri);
        
        httpPost.addHeader(HTTP.CONTENT_TYPE, "application/json; charset=utf-8");
        httpPost.addHeader("x-tsm-cplc", this.getxTsmCplc()); //安全载体CPLC
        httpPost.addHeader("x-smps-callerid", this.getX_smps_callerid()); //交易请求方标识
        Date date=new Date();
        SimpleDateFormat sdf=new SimpleDateFormat("yyyyMMddhhmmss");
        httpPost.addHeader("transTimeSource", sdf.format(date)); //发起方交易时间
        httpPost.addHeader("transNoSource", Long.toString(System.currentTimeMillis()));
        
        StringEntity se;
		try {
			se = new StringEntity(json);
			se.setContentEncoding("utf-8");
			se.setContentType("application/json");
			httpPost.setEntity(se);
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
      
        return httpPost;
	}
	
public String getSDKRequest(String req_plain) throws Exception{
		
		String rsa_private_key=this.getRsaKey();
		
		String secret_key=this.getSecretKey();
		
		EpaySDKReq epaySDKRequest = new EpaySDKReq(req_sys, version,secret_key, rsa_private_key);
		//是否加密
		epaySDKRequest.setEncrypt_open(encrypt_open);
		//是否签名
		epaySDKRequest.setSign_open(sign_open);
		
		String req = epaySDKRequest.getReqMsg(req_plain);
		epaySDKReq=epaySDKRequest;
		return req;
	}
	private String getRsaKey(){
		if(this.env.equals("test")||this.env.equals("local")){
			if(req_sys.equals("0003")){
				return test_rsa_private_key_0003;
			}else if(req_sys.equals("0032")){
				return test_rsa_private_key_0032;
			}else{
				return test_rsa_private_key_0027;
			}
		}else if(this.env.equals("product")){
		   if(req_sys.equals("0027")){
				return product_rsa_private_key_0027;
			}
		   if(req_sys.equals("0032")){
				return product_rsa_private_key_0032;
			}
		   if(req_sys.equals("0003")){
				return product_rsa_private_key_0003;
			}
		}
		return test_rsa_private_key_0027;
	}
	private String getSecretKey(){
		if(this.env.equals("test")||this.env.equals("local")){
			if(req_sys.equals("0003")){
				return test_secret_key_0003;
			}else if(req_sys.equals("0032")){
				return test_secret_key_0032;
			}else{
				return test_secret_key_0027;
			}
		}else  if(this.env.equals("product")){
			if(req_sys.equals("0027")){
				return product_secret_key_0027;
			}
			if(req_sys.equals("0003")){
				return product_secret_key_0003;
			}
			if(req_sys.equals("0032")){
				return product_secret_key_0032;
			}
		}
		return test_secret_key_0027;
	}
	public String getTrans_code() {
		return trans_code;
	}
	public void setTrans_code(String trans_code) {
		this.trans_code = trans_code;
	}
	public String getReq_sys() {
		return req_sys;
	}
	public void setReq_sys(String req_sys) {
		this.req_sys = req_sys;
	}
	public String getEnv() {
		return env;
	}
	public void setEnv(String env) {
		this.env = env;
	}

	public String getX_smps_callerid() {
		return x_smps_callerid;
	}
	public void setX_smps_callerid(String x_smps_callerid) {
		this.x_smps_callerid = x_smps_callerid;
	}
	public String getUri() {
		return uri;
	}
	public void setUri(String uri) {
		this.uri = uri;
	}
	public String getxTsmCplc() {
		return xTsmCplc;
	}
	public void setxTsmCplc(String xTsmCplc) {
		this.xTsmCplc = xTsmCplc;
	}
	public boolean isEncrypt_open() {
		return encrypt_open;
	}
	public void setEncrypt_open(boolean encrypt_open) {
		this.encrypt_open = encrypt_open;
	}
	public boolean isSign_open() {
		return sign_open;
	}
	public void setSign_open(boolean sign_open) {
		this.sign_open = sign_open;
	}
	
}
