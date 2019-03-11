#!/usr/bin/env python3
# coding=utf-8
import sys

import requests

reload(sys)
sys.setdefaultencoding('utf8')

appkey = ['poi-relation-service-web', 'com.sankuai.mobile.group.sinai', 'com.sankuai.mobile.group.sinai.spec', 'com.sankuai.cos.mtpoiop.api', 'dp-poi-service']

oneMonthMinute = 60 * 24 * 365

cat_topological_url = 'http://cat.vip.sankuai.com/cat/r/q'
cat_params = {'op': 'queryTopologyService', 'domain': '', 'timeRange': oneMonthMinute,
              'token': 'b92a0683d54d4eba8f91e552a8480636'}

ops_headers = {'Authorization': 'Bearer 364ebf21e25b618b44b3db036f33d9f81ec8724f'}
ops_url = 'http://ops.vip.sankuai.com/api/v0.2/appkeys/'

f = open('/Users/bailei/Downloads/hello.txt', 'w+')
f.write(','.join(['应用', '调用方', 'businessName', '负责人', '\n']))

total = 0
rpc_total = 0

for app in appkey:
    cat_params['domain'] = app
    cat_r = requests.get(cat_topological_url, params=cat_params)
    cat_json = cat_r.json()
    if cat_json['code'] != 200:
        continue
    upStreams = cat_r.json()['data']['upStreams']
    for key, key_value in upStreams.items():
        total += 1
        if u'RPC' != key_value['type']:  # rpc上游统计
            continue
        rpc_total += 1
        result = [app]
        app_detail = requests.get(ops_url + key, headers=ops_headers).json()['appkey']
        if app_detail:  # 查不到的app
            result.append(app_detail['appkey'])
            result.append(app_detail['businessName'])
            result.append(app_detail['owners'][0]['login'])
        else:
            result.append(key)

        result.append('\n')

        print ','.join(result)
        f.write(','.join(result))
f.write('总计：{0}, rpc依赖数: {1}'.format(total, rpc_total))
f.close()
