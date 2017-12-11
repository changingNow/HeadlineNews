package com.lw.headlinenews.bean;

/**
 * Created by lw on 17-12-11.
 */

public class VideoContentBean {

    /**
     * data : {"status":10,"user_id":"toutiao","video_id":"9166d11ab2df4435af3166d183f71bad","validate":"","enable_ssl":false,"poster_url":"http://p3.pstatp.com/origin/4c4c000534935ff918c5","video_duration":2732.82,"auto_definition":"480p","video_list":{"video_1":{"definition":"360p","vtype":"mp4","vwidth":440,"vheight":360,"bitrate":78509,"size":50427334,"codec_type":"h264","logo_type":"xigua","file_hash":"ba6a1e8ad7efe8fb26249da16482b21c","main_url":"aHR0cDovL3YxMS10dC5peGlndWEuY29tLzJiNzc5ZDhiMzhkNDAwYTI0MDQ1ZTVhYzFmNjMyZWY5LzVhMmU1NjEwL3ZpZGVvL20vMjIwZGE5YTc3MDdmNjMwNGM3ZjhiNjgyNDhhZWVmYzc4MTQxMTUyZTNjYTAwMDBhOTI0NTA2NzI2Yzgv","backup_url_1":"aHR0cDovL3Y3LnBzdGF0cC5jb20vNTU5Y2Y5OGVlMTY2NjgyZGI3MzRkNmRjMDQ1NmNjNGEvNWEyZTU2MTAvdmlkZW8vbS8yMjBkYTlhNzcwN2Y2MzA0YzdmOGI2ODI0OGFlZWZjNzgxNDExNTJlM2NhMDAwMGE5MjQ1MDY3MjZjOC8=","user_video_proxy":1,"socket_buffer":1766340,"preload_size":327680,"preload_interval":60,"preload_min_step":5,"preload_max_step":10},"video_2":{"definition":"480p","vtype":"mp4","vwidth":586,"vheight":480,"bitrate":127074,"size":67013203,"codec_type":"h264","logo_type":"xigua","file_hash":"d47d3ebf16694abd3584edec05ee119f","main_url":"aHR0cDovL3YxMS10dC5peGlndWEuY29tLzViMTZkNTg5M2M2MzM2NjQyNWQxOGU5N2IwODhiN2U0LzVhMmU1NjEwL3ZpZGVvL20vMjIwYzY4OTYyYmQxZDYwNGViYWIyMTYyOGIyMjkxOGIzMDExMTUyZTFjYzAwMDAzZWViMWY1NDIyMmQv","backup_url_1":"aHR0cDovL3Y3LnBzdGF0cC5jb20vODBiYjY3ZDM0N2M4NzFiNzJiZWI1MjE5ZTUxODJmOTYvNWEyZTU2MTAvdmlkZW8vbS8yMjBjNjg5NjJiZDFkNjA0ZWJhYjIxNjI4YjIyOTE4YjMwMTExNTJlMWNjMDAwMDNlZWIxZjU0MjIyZC8=","user_video_proxy":1,"socket_buffer":2859120,"preload_size":327680,"preload_interval":60,"preload_min_step":5,"preload_max_step":10},"video_3":{"definition":"720p","vtype":"mp4","vwidth":704,"vheight":576,"bitrate":252191,"size":109795403,"codec_type":"h264","logo_type":"xigua","file_hash":"17fcc0c724697a81d8e911e6dc615e9a","main_url":"aHR0cDovL3YxMS10dC5peGlndWEuY29tLzA0ZDBiM2ZiMGM1OGI0MGRhYzE4N2U1ZDBmNjY3OGRiLzVhMmU1NjEwL3ZpZGVvL20vMjIwZGUxNmUxNTc4MDNhNGE0MmJlMDA5ZmFhMzAxNjU1NGQxMTUyYzgxNzAwMDA5ZGYzMzEwZGQ3Zjcv","backup_url_1":"aHR0cDovL3Y3LnBzdGF0cC5jb20vNzQwZDk0NDQyZWNlMzRmOTBmZWIxN2FmN2YzMTg2NDYvNWEyZTU2MTAvdmlkZW8vbS8yMjBkZTE2ZTE1NzgwM2E0YTQyYmUwMDlmYWEzMDE2NTU0ZDExNTJjODE3MDAwMDlkZjMzMTBkZDdmNy8=","user_video_proxy":1,"socket_buffer":5674140,"preload_size":327680,"preload_interval":60,"preload_min_step":5,"preload_max_step":10}}}
     * message : success
     * code : 0
     * total : 3
     */

    private DataBean data;
    private String message;
    private int code;
    private int total;

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public static class DataBean {
        /**
         * status : 10
         * user_id : toutiao
         * video_id : 9166d11ab2df4435af3166d183f71bad
         * validate :
         * enable_ssl : false
         * poster_url : http://p3.pstatp.com/origin/4c4c000534935ff918c5
         * video_duration : 2732.82
         * auto_definition : 480p
         * video_list : {"video_1":{"definition":"360p","vtype":"mp4","vwidth":440,"vheight":360,"bitrate":78509,"size":50427334,"codec_type":"h264","logo_type":"xigua","file_hash":"ba6a1e8ad7efe8fb26249da16482b21c","main_url":"aHR0cDovL3YxMS10dC5peGlndWEuY29tLzJiNzc5ZDhiMzhkNDAwYTI0MDQ1ZTVhYzFmNjMyZWY5LzVhMmU1NjEwL3ZpZGVvL20vMjIwZGE5YTc3MDdmNjMwNGM3ZjhiNjgyNDhhZWVmYzc4MTQxMTUyZTNjYTAwMDBhOTI0NTA2NzI2Yzgv","backup_url_1":"aHR0cDovL3Y3LnBzdGF0cC5jb20vNTU5Y2Y5OGVlMTY2NjgyZGI3MzRkNmRjMDQ1NmNjNGEvNWEyZTU2MTAvdmlkZW8vbS8yMjBkYTlhNzcwN2Y2MzA0YzdmOGI2ODI0OGFlZWZjNzgxNDExNTJlM2NhMDAwMGE5MjQ1MDY3MjZjOC8=","user_video_proxy":1,"socket_buffer":1766340,"preload_size":327680,"preload_interval":60,"preload_min_step":5,"preload_max_step":10},"video_2":{"definition":"480p","vtype":"mp4","vwidth":586,"vheight":480,"bitrate":127074,"size":67013203,"codec_type":"h264","logo_type":"xigua","file_hash":"d47d3ebf16694abd3584edec05ee119f","main_url":"aHR0cDovL3YxMS10dC5peGlndWEuY29tLzViMTZkNTg5M2M2MzM2NjQyNWQxOGU5N2IwODhiN2U0LzVhMmU1NjEwL3ZpZGVvL20vMjIwYzY4OTYyYmQxZDYwNGViYWIyMTYyOGIyMjkxOGIzMDExMTUyZTFjYzAwMDAzZWViMWY1NDIyMmQv","backup_url_1":"aHR0cDovL3Y3LnBzdGF0cC5jb20vODBiYjY3ZDM0N2M4NzFiNzJiZWI1MjE5ZTUxODJmOTYvNWEyZTU2MTAvdmlkZW8vbS8yMjBjNjg5NjJiZDFkNjA0ZWJhYjIxNjI4YjIyOTE4YjMwMTExNTJlMWNjMDAwMDNlZWIxZjU0MjIyZC8=","user_video_proxy":1,"socket_buffer":2859120,"preload_size":327680,"preload_interval":60,"preload_min_step":5,"preload_max_step":10},"video_3":{"definition":"720p","vtype":"mp4","vwidth":704,"vheight":576,"bitrate":252191,"size":109795403,"codec_type":"h264","logo_type":"xigua","file_hash":"17fcc0c724697a81d8e911e6dc615e9a","main_url":"aHR0cDovL3YxMS10dC5peGlndWEuY29tLzA0ZDBiM2ZiMGM1OGI0MGRhYzE4N2U1ZDBmNjY3OGRiLzVhMmU1NjEwL3ZpZGVvL20vMjIwZGUxNmUxNTc4MDNhNGE0MmJlMDA5ZmFhMzAxNjU1NGQxMTUyYzgxNzAwMDA5ZGYzMzEwZGQ3Zjcv","backup_url_1":"aHR0cDovL3Y3LnBzdGF0cC5jb20vNzQwZDk0NDQyZWNlMzRmOTBmZWIxN2FmN2YzMTg2NDYvNWEyZTU2MTAvdmlkZW8vbS8yMjBkZTE2ZTE1NzgwM2E0YTQyYmUwMDlmYWEzMDE2NTU0ZDExNTJjODE3MDAwMDlkZjMzMTBkZDdmNy8=","user_video_proxy":1,"socket_buffer":5674140,"preload_size":327680,"preload_interval":60,"preload_min_step":5,"preload_max_step":10}}
         */

        private int status;
        private String user_id;
        private String video_id;
        private String validate;
        private boolean enable_ssl;
        private String poster_url;
        private double video_duration;
        private String auto_definition;
        private VideoListBean video_list;

        public int getStatus() {
            return status;
        }

        public void setStatus(int status) {
            this.status = status;
        }

        public String getUser_id() {
            return user_id;
        }

        public void setUser_id(String user_id) {
            this.user_id = user_id;
        }

        public String getVideo_id() {
            return video_id;
        }

        public void setVideo_id(String video_id) {
            this.video_id = video_id;
        }

        public String getValidate() {
            return validate;
        }

        public void setValidate(String validate) {
            this.validate = validate;
        }

        public boolean isEnable_ssl() {
            return enable_ssl;
        }

        public void setEnable_ssl(boolean enable_ssl) {
            this.enable_ssl = enable_ssl;
        }

        public String getPoster_url() {
            return poster_url;
        }

        public void setPoster_url(String poster_url) {
            this.poster_url = poster_url;
        }

        public double getVideo_duration() {
            return video_duration;
        }

        public void setVideo_duration(double video_duration) {
            this.video_duration = video_duration;
        }

        public String getAuto_definition() {
            return auto_definition;
        }

        public void setAuto_definition(String auto_definition) {
            this.auto_definition = auto_definition;
        }

        public VideoListBean getVideo_list() {
            return video_list;
        }

        public void setVideo_list(VideoListBean video_list) {
            this.video_list = video_list;
        }

        public static class VideoListBean {
            /**
             * video_1 : {"definition":"360p","vtype":"mp4","vwidth":440,"vheight":360,"bitrate":78509,"size":50427334,"codec_type":"h264","logo_type":"xigua","file_hash":"ba6a1e8ad7efe8fb26249da16482b21c","main_url":"aHR0cDovL3YxMS10dC5peGlndWEuY29tLzJiNzc5ZDhiMzhkNDAwYTI0MDQ1ZTVhYzFmNjMyZWY5LzVhMmU1NjEwL3ZpZGVvL20vMjIwZGE5YTc3MDdmNjMwNGM3ZjhiNjgyNDhhZWVmYzc4MTQxMTUyZTNjYTAwMDBhOTI0NTA2NzI2Yzgv","backup_url_1":"aHR0cDovL3Y3LnBzdGF0cC5jb20vNTU5Y2Y5OGVlMTY2NjgyZGI3MzRkNmRjMDQ1NmNjNGEvNWEyZTU2MTAvdmlkZW8vbS8yMjBkYTlhNzcwN2Y2MzA0YzdmOGI2ODI0OGFlZWZjNzgxNDExNTJlM2NhMDAwMGE5MjQ1MDY3MjZjOC8=","user_video_proxy":1,"socket_buffer":1766340,"preload_size":327680,"preload_interval":60,"preload_min_step":5,"preload_max_step":10}
             * video_2 : {"definition":"480p","vtype":"mp4","vwidth":586,"vheight":480,"bitrate":127074,"size":67013203,"codec_type":"h264","logo_type":"xigua","file_hash":"d47d3ebf16694abd3584edec05ee119f","main_url":"aHR0cDovL3YxMS10dC5peGlndWEuY29tLzViMTZkNTg5M2M2MzM2NjQyNWQxOGU5N2IwODhiN2U0LzVhMmU1NjEwL3ZpZGVvL20vMjIwYzY4OTYyYmQxZDYwNGViYWIyMTYyOGIyMjkxOGIzMDExMTUyZTFjYzAwMDAzZWViMWY1NDIyMmQv","backup_url_1":"aHR0cDovL3Y3LnBzdGF0cC5jb20vODBiYjY3ZDM0N2M4NzFiNzJiZWI1MjE5ZTUxODJmOTYvNWEyZTU2MTAvdmlkZW8vbS8yMjBjNjg5NjJiZDFkNjA0ZWJhYjIxNjI4YjIyOTE4YjMwMTExNTJlMWNjMDAwMDNlZWIxZjU0MjIyZC8=","user_video_proxy":1,"socket_buffer":2859120,"preload_size":327680,"preload_interval":60,"preload_min_step":5,"preload_max_step":10}
             * video_3 : {"definition":"720p","vtype":"mp4","vwidth":704,"vheight":576,"bitrate":252191,"size":109795403,"codec_type":"h264","logo_type":"xigua","file_hash":"17fcc0c724697a81d8e911e6dc615e9a","main_url":"aHR0cDovL3YxMS10dC5peGlndWEuY29tLzA0ZDBiM2ZiMGM1OGI0MGRhYzE4N2U1ZDBmNjY3OGRiLzVhMmU1NjEwL3ZpZGVvL20vMjIwZGUxNmUxNTc4MDNhNGE0MmJlMDA5ZmFhMzAxNjU1NGQxMTUyYzgxNzAwMDA5ZGYzMzEwZGQ3Zjcv","backup_url_1":"aHR0cDovL3Y3LnBzdGF0cC5jb20vNzQwZDk0NDQyZWNlMzRmOTBmZWIxN2FmN2YzMTg2NDYvNWEyZTU2MTAvdmlkZW8vbS8yMjBkZTE2ZTE1NzgwM2E0YTQyYmUwMDlmYWEzMDE2NTU0ZDExNTJjODE3MDAwMDlkZjMzMTBkZDdmNy8=","user_video_proxy":1,"socket_buffer":5674140,"preload_size":327680,"preload_interval":60,"preload_min_step":5,"preload_max_step":10}
             */

            private Video1Bean video_1;
            private Video2Bean video_2;
            private Video3Bean video_3;

            public Video1Bean getVideo_1() {
                return video_1;
            }

            public void setVideo_1(Video1Bean video_1) {
                this.video_1 = video_1;
            }

            public Video2Bean getVideo_2() {
                return video_2;
            }

            public void setVideo_2(Video2Bean video_2) {
                this.video_2 = video_2;
            }

            public Video3Bean getVideo_3() {
                return video_3;
            }

            public void setVideo_3(Video3Bean video_3) {
                this.video_3 = video_3;
            }

            public static class Video1Bean {
                /**
                 * definition : 360p
                 * vtype : mp4
                 * vwidth : 440
                 * vheight : 360
                 * bitrate : 78509
                 * size : 50427334
                 * codec_type : h264
                 * logo_type : xigua
                 * file_hash : ba6a1e8ad7efe8fb26249da16482b21c
                 * main_url : aHR0cDovL3YxMS10dC5peGlndWEuY29tLzJiNzc5ZDhiMzhkNDAwYTI0MDQ1ZTVhYzFmNjMyZWY5LzVhMmU1NjEwL3ZpZGVvL20vMjIwZGE5YTc3MDdmNjMwNGM3ZjhiNjgyNDhhZWVmYzc4MTQxMTUyZTNjYTAwMDBhOTI0NTA2NzI2Yzgv
                 * backup_url_1 : aHR0cDovL3Y3LnBzdGF0cC5jb20vNTU5Y2Y5OGVlMTY2NjgyZGI3MzRkNmRjMDQ1NmNjNGEvNWEyZTU2MTAvdmlkZW8vbS8yMjBkYTlhNzcwN2Y2MzA0YzdmOGI2ODI0OGFlZWZjNzgxNDExNTJlM2NhMDAwMGE5MjQ1MDY3MjZjOC8=
                 * user_video_proxy : 1
                 * socket_buffer : 1766340
                 * preload_size : 327680
                 * preload_interval : 60
                 * preload_min_step : 5
                 * preload_max_step : 10
                 */

                private String definition;
                private String vtype;
                private int vwidth;
                private int vheight;
                private int bitrate;
                private int size;
                private String codec_type;
                private String logo_type;
                private String file_hash;
                private String main_url;
                private String backup_url_1;
                private int user_video_proxy;
                private int socket_buffer;
                private int preload_size;
                private int preload_interval;
                private int preload_min_step;
                private int preload_max_step;

                public String getDefinition() {
                    return definition;
                }

                public void setDefinition(String definition) {
                    this.definition = definition;
                }

                public String getVtype() {
                    return vtype;
                }

                public void setVtype(String vtype) {
                    this.vtype = vtype;
                }

                public int getVwidth() {
                    return vwidth;
                }

                public void setVwidth(int vwidth) {
                    this.vwidth = vwidth;
                }

                public int getVheight() {
                    return vheight;
                }

                public void setVheight(int vheight) {
                    this.vheight = vheight;
                }

                public int getBitrate() {
                    return bitrate;
                }

                public void setBitrate(int bitrate) {
                    this.bitrate = bitrate;
                }

                public int getSize() {
                    return size;
                }

                public void setSize(int size) {
                    this.size = size;
                }

                public String getCodec_type() {
                    return codec_type;
                }

                public void setCodec_type(String codec_type) {
                    this.codec_type = codec_type;
                }

                public String getLogo_type() {
                    return logo_type;
                }

                public void setLogo_type(String logo_type) {
                    this.logo_type = logo_type;
                }

                public String getFile_hash() {
                    return file_hash;
                }

                public void setFile_hash(String file_hash) {
                    this.file_hash = file_hash;
                }

                public String getMain_url() {
                    return main_url;
                }

                public void setMain_url(String main_url) {
                    this.main_url = main_url;
                }

                public String getBackup_url_1() {
                    return backup_url_1;
                }

                public void setBackup_url_1(String backup_url_1) {
                    this.backup_url_1 = backup_url_1;
                }

                public int getUser_video_proxy() {
                    return user_video_proxy;
                }

                public void setUser_video_proxy(int user_video_proxy) {
                    this.user_video_proxy = user_video_proxy;
                }

                public int getSocket_buffer() {
                    return socket_buffer;
                }

                public void setSocket_buffer(int socket_buffer) {
                    this.socket_buffer = socket_buffer;
                }

                public int getPreload_size() {
                    return preload_size;
                }

                public void setPreload_size(int preload_size) {
                    this.preload_size = preload_size;
                }

                public int getPreload_interval() {
                    return preload_interval;
                }

                public void setPreload_interval(int preload_interval) {
                    this.preload_interval = preload_interval;
                }

                public int getPreload_min_step() {
                    return preload_min_step;
                }

                public void setPreload_min_step(int preload_min_step) {
                    this.preload_min_step = preload_min_step;
                }

                public int getPreload_max_step() {
                    return preload_max_step;
                }

                public void setPreload_max_step(int preload_max_step) {
                    this.preload_max_step = preload_max_step;
                }
            }

            public static class Video2Bean {
                /**
                 * definition : 480p
                 * vtype : mp4
                 * vwidth : 586
                 * vheight : 480
                 * bitrate : 127074
                 * size : 67013203
                 * codec_type : h264
                 * logo_type : xigua
                 * file_hash : d47d3ebf16694abd3584edec05ee119f
                 * main_url : aHR0cDovL3YxMS10dC5peGlndWEuY29tLzViMTZkNTg5M2M2MzM2NjQyNWQxOGU5N2IwODhiN2U0LzVhMmU1NjEwL3ZpZGVvL20vMjIwYzY4OTYyYmQxZDYwNGViYWIyMTYyOGIyMjkxOGIzMDExMTUyZTFjYzAwMDAzZWViMWY1NDIyMmQv
                 * backup_url_1 : aHR0cDovL3Y3LnBzdGF0cC5jb20vODBiYjY3ZDM0N2M4NzFiNzJiZWI1MjE5ZTUxODJmOTYvNWEyZTU2MTAvdmlkZW8vbS8yMjBjNjg5NjJiZDFkNjA0ZWJhYjIxNjI4YjIyOTE4YjMwMTExNTJlMWNjMDAwMDNlZWIxZjU0MjIyZC8=
                 * user_video_proxy : 1
                 * socket_buffer : 2859120
                 * preload_size : 327680
                 * preload_interval : 60
                 * preload_min_step : 5
                 * preload_max_step : 10
                 */

                private String definition;
                private String vtype;
                private int vwidth;
                private int vheight;
                private int bitrate;
                private int size;
                private String codec_type;
                private String logo_type;
                private String file_hash;
                private String main_url;
                private String backup_url_1;
                private int user_video_proxy;
                private int socket_buffer;
                private int preload_size;
                private int preload_interval;
                private int preload_min_step;
                private int preload_max_step;

                public String getDefinition() {
                    return definition;
                }

                public void setDefinition(String definition) {
                    this.definition = definition;
                }

                public String getVtype() {
                    return vtype;
                }

                public void setVtype(String vtype) {
                    this.vtype = vtype;
                }

                public int getVwidth() {
                    return vwidth;
                }

                public void setVwidth(int vwidth) {
                    this.vwidth = vwidth;
                }

                public int getVheight() {
                    return vheight;
                }

                public void setVheight(int vheight) {
                    this.vheight = vheight;
                }

                public int getBitrate() {
                    return bitrate;
                }

                public void setBitrate(int bitrate) {
                    this.bitrate = bitrate;
                }

                public int getSize() {
                    return size;
                }

                public void setSize(int size) {
                    this.size = size;
                }

                public String getCodec_type() {
                    return codec_type;
                }

                public void setCodec_type(String codec_type) {
                    this.codec_type = codec_type;
                }

                public String getLogo_type() {
                    return logo_type;
                }

                public void setLogo_type(String logo_type) {
                    this.logo_type = logo_type;
                }

                public String getFile_hash() {
                    return file_hash;
                }

                public void setFile_hash(String file_hash) {
                    this.file_hash = file_hash;
                }

                public String getMain_url() {
                    return main_url;
                }

                public void setMain_url(String main_url) {
                    this.main_url = main_url;
                }

                public String getBackup_url_1() {
                    return backup_url_1;
                }

                public void setBackup_url_1(String backup_url_1) {
                    this.backup_url_1 = backup_url_1;
                }

                public int getUser_video_proxy() {
                    return user_video_proxy;
                }

                public void setUser_video_proxy(int user_video_proxy) {
                    this.user_video_proxy = user_video_proxy;
                }

                public int getSocket_buffer() {
                    return socket_buffer;
                }

                public void setSocket_buffer(int socket_buffer) {
                    this.socket_buffer = socket_buffer;
                }

                public int getPreload_size() {
                    return preload_size;
                }

                public void setPreload_size(int preload_size) {
                    this.preload_size = preload_size;
                }

                public int getPreload_interval() {
                    return preload_interval;
                }

                public void setPreload_interval(int preload_interval) {
                    this.preload_interval = preload_interval;
                }

                public int getPreload_min_step() {
                    return preload_min_step;
                }

                public void setPreload_min_step(int preload_min_step) {
                    this.preload_min_step = preload_min_step;
                }

                public int getPreload_max_step() {
                    return preload_max_step;
                }

                public void setPreload_max_step(int preload_max_step) {
                    this.preload_max_step = preload_max_step;
                }
            }

            public static class Video3Bean {
                /**
                 * definition : 720p
                 * vtype : mp4
                 * vwidth : 704
                 * vheight : 576
                 * bitrate : 252191
                 * size : 109795403
                 * codec_type : h264
                 * logo_type : xigua
                 * file_hash : 17fcc0c724697a81d8e911e6dc615e9a
                 * main_url : aHR0cDovL3YxMS10dC5peGlndWEuY29tLzA0ZDBiM2ZiMGM1OGI0MGRhYzE4N2U1ZDBmNjY3OGRiLzVhMmU1NjEwL3ZpZGVvL20vMjIwZGUxNmUxNTc4MDNhNGE0MmJlMDA5ZmFhMzAxNjU1NGQxMTUyYzgxNzAwMDA5ZGYzMzEwZGQ3Zjcv
                 * backup_url_1 : aHR0cDovL3Y3LnBzdGF0cC5jb20vNzQwZDk0NDQyZWNlMzRmOTBmZWIxN2FmN2YzMTg2NDYvNWEyZTU2MTAvdmlkZW8vbS8yMjBkZTE2ZTE1NzgwM2E0YTQyYmUwMDlmYWEzMDE2NTU0ZDExNTJjODE3MDAwMDlkZjMzMTBkZDdmNy8=
                 * user_video_proxy : 1
                 * socket_buffer : 5674140
                 * preload_size : 327680
                 * preload_interval : 60
                 * preload_min_step : 5
                 * preload_max_step : 10
                 */

                private String definition;
                private String vtype;
                private int vwidth;
                private int vheight;
                private int bitrate;
                private int size;
                private String codec_type;
                private String logo_type;
                private String file_hash;
                private String main_url;
                private String backup_url_1;
                private int user_video_proxy;
                private int socket_buffer;
                private int preload_size;
                private int preload_interval;
                private int preload_min_step;
                private int preload_max_step;

                public String getDefinition() {
                    return definition;
                }

                public void setDefinition(String definition) {
                    this.definition = definition;
                }

                public String getVtype() {
                    return vtype;
                }

                public void setVtype(String vtype) {
                    this.vtype = vtype;
                }

                public int getVwidth() {
                    return vwidth;
                }

                public void setVwidth(int vwidth) {
                    this.vwidth = vwidth;
                }

                public int getVheight() {
                    return vheight;
                }

                public void setVheight(int vheight) {
                    this.vheight = vheight;
                }

                public int getBitrate() {
                    return bitrate;
                }

                public void setBitrate(int bitrate) {
                    this.bitrate = bitrate;
                }

                public int getSize() {
                    return size;
                }

                public void setSize(int size) {
                    this.size = size;
                }

                public String getCodec_type() {
                    return codec_type;
                }

                public void setCodec_type(String codec_type) {
                    this.codec_type = codec_type;
                }

                public String getLogo_type() {
                    return logo_type;
                }

                public void setLogo_type(String logo_type) {
                    this.logo_type = logo_type;
                }

                public String getFile_hash() {
                    return file_hash;
                }

                public void setFile_hash(String file_hash) {
                    this.file_hash = file_hash;
                }

                public String getMain_url() {
                    return main_url;
                }

                public void setMain_url(String main_url) {
                    this.main_url = main_url;
                }

                public String getBackup_url_1() {
                    return backup_url_1;
                }

                public void setBackup_url_1(String backup_url_1) {
                    this.backup_url_1 = backup_url_1;
                }

                public int getUser_video_proxy() {
                    return user_video_proxy;
                }

                public void setUser_video_proxy(int user_video_proxy) {
                    this.user_video_proxy = user_video_proxy;
                }

                public int getSocket_buffer() {
                    return socket_buffer;
                }

                public void setSocket_buffer(int socket_buffer) {
                    this.socket_buffer = socket_buffer;
                }

                public int getPreload_size() {
                    return preload_size;
                }

                public void setPreload_size(int preload_size) {
                    this.preload_size = preload_size;
                }

                public int getPreload_interval() {
                    return preload_interval;
                }

                public void setPreload_interval(int preload_interval) {
                    this.preload_interval = preload_interval;
                }

                public int getPreload_min_step() {
                    return preload_min_step;
                }

                public void setPreload_min_step(int preload_min_step) {
                    this.preload_min_step = preload_min_step;
                }

                public int getPreload_max_step() {
                    return preload_max_step;
                }

                public void setPreload_max_step(int preload_max_step) {
                    this.preload_max_step = preload_max_step;
                }
            }
        }
    }
}
